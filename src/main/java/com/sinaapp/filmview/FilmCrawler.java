package com.sinaapp.filmview;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: fanshen.fs
 * version:1.0  14-10-1
 */
public class FilmCrawler extends ActionSupport {

    String url;
    String filmHtmlDoc;
    FilmInfo filmInfo;
    String callback;
    String saved;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilmHtmlDoc() {
        return filmHtmlDoc;
    }

    public void setFilmHtmlDoc(String filmHtmlDoc) {
        this.filmHtmlDoc = filmHtmlDoc;
    }

    public FilmInfo getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getSaved() {
        return saved;
    }

    public void setSaved(String saved) {
        this.saved = saved;
    }

    public String fetch() throws IOException {
        String filmUrl = URLDecoder.decode(url, "UTF-8");
        Connection conn = Jsoup.connect(filmUrl);
        Document doc = conn.get();

//        SaeFetchUrl fetch = new SaeFetchUrl();
//        String html = fetch.fetch(filmUrl);
//        Document doc = Jsoup.parse(html);
        filmInfo = getFilmFromDocument(doc);
        if (filmInfo != null) {
            filmHtmlDoc = filmInfo.toString();
            callback = "true";
        } else {
            filmHtmlDoc = "Can not get filmInfo.";
            callback = "false";
        }
        return SUCCESS;
    }

    public static FilmInfo getFilmFromDocument(Document doc) {

        try {
            String filmName = doc.select("#content > h1 > span:nth-child(1)").text();  // 电影名
            System.out.println(filmName);
            String director = doc.select("#info > span:nth-child(1) > a").text();   // 导演
            String starring = doc.select("#info > span:nth-child(5)").text();          // 主角
            String filmType = doc.getElementsByAttributeValue("property", "v:genre").text(); //电影类型
            String filmTime = doc.getElementsByAttributeValue("property", "v:initialReleaseDate").text(); // 上映时间
            String scoreSt = doc.getElementsByAttributeValue("property", "v:average").text();
            double score = 0;
            if (!scoreSt.isEmpty()) {
                score = Double.parseDouble(scoreSt); // 电影评分
            }
            String filmIntro = doc.select("#link-report > span.all.hidden").text().replaceAll("\"", "\'");       // 电影简介
            if (filmIntro.isEmpty())
                filmIntro = doc.select("#link-report > span:nth-child(1)").text().replaceAll("\"", "\'");
            if (filmIntro.isEmpty()) {
                System.out.println(filmName + "can not be analysed.");
                return null;
            }
            String filmReview = doc.select("#hot-comments > div:nth-child(1) > div > p").text().replaceAll("\"", "\'"); //电影评语
            String picUrl = doc.select("#mainpic > a > img").attr("src");
            if (picUrl != null){
                try {
                    savePic(picUrl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                picUrl = picUrl.substring(picUrl.lastIndexOf("/"));
            }
            else{
                picUrl = "";
            }
            FilmInfo film = new FilmInfo(filmName, director, starring, filmType, filmTime, score, filmIntro, filmReview,picUrl);
            System.out.println("getFilmFromDocument: " + film);
            return film;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String saveFilm() throws IOException {

        String filmUrl = URLDecoder.decode(url, "UTF-8");
        System.out.println(filmUrl);
        Connection conn = Jsoup.connect(filmUrl);
        Document doc = conn.get();
        filmInfo = getFilmFromDocument(doc);

        saved = "false";
        String tableName = "film";
        java.sql.Connection sqlconn = Search.getConnection();
        if (filmInfo != null && sqlconn != null) {
            if (CheckIfNotExist(sqlconn, tableName, filmInfo)){
                try {
                    Statement statement = sqlconn.createStatement();

                    String sql = "INSERT INTO " + tableName + " VALUES (" +
                            filmInfo.toString() + ")";

                    // 执行SQL语句
                    int rt = statement.executeUpdate(sql);
                    System.out.println("rt:" + rt);
                    if (rt == 1) {
                        saved = "true";
                    } else {
                        saved = "false";
                    }
                    sqlconn.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                saved = "Exists";
            }
        }
        return SUCCESS;
    }

    public boolean CheckIfNotExist(java.sql.Connection sqlconn, String tableName, FilmInfo filmInfo) {
        if (sqlconn != null) {
            try {
                Statement statement = sqlconn.createStatement();

                String sql = "SELECT * FROM " + tableName + " WHERE filmName=" + "\'" + filmInfo.getFilmName() + "\'";

                System.out.println(sql);

                // 执行SQL语句
                ResultSet rs = statement.executeQuery(sql);
                return !rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static void savePic(String picUrl) throws Exception {

        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        java.net.URL url = classLoader.getResource("");
        String ROOT_CLASS_PATH = url.getPath() + "/";
        File rootFile = new File(ROOT_CLASS_PATH);
        String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";
        File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);
        String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/";

        String PIC_DIR = SERVLET_CONTEXT_PATH +"pics";

        String fileName = picUrl.substring(picUrl.lastIndexOf("/"));
        String filePath = PIC_DIR + "/" + fileName;
        System.out.println(filePath);
        BufferedOutputStream out = null;
        byte[] bit = getByte(picUrl);
        if (bit.length > 0) {
            try {
                out = new BufferedOutputStream(new FileOutputStream(filePath));
                out.write(bit);
                out.flush();

            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }
    }

    public static byte[] getByte(String uri) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toByteArray(entity);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            response.close();
        }
        return new byte[0];
    }

}
