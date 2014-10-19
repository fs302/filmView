package com.sinaapp.filmview;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Author: fanshen.fs
 * version:1.0  14-10-1
 */
public class FilmCrawler extends ActionSupport {

    private static final Logger logger = LogManager.getLogger(FilmCrawler.class);

    String url;
    String filmHtmlDoc;
    FilmInfo filmInfo;
    String callback;

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

    public String fetch() throws IOException {
        if (url==null){
            callback="false";
            return SUCCESS;
        }
        String filmUrl = URLDecoder.decode(url, "UTF-8");
        Connection conn = Jsoup.connect(filmUrl);
        Document doc = conn.get();

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
            logger.info("[getFilmFromDocument] " + filmName);
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
                logger.warn("[getFilmFromDocument] " + filmName + "can not be analysed.");
                return null;
            }
            String filmReview = doc.select("#hot-comments > div:nth-child(1) > div > p").text().replaceAll("\"", "\'"); //电影评语
            String picUrl = doc.select("#mainpic > a > img").attr("src");
            if (picUrl == null){
                picUrl = "";
            }else {
                try {
                    savePic(picUrl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                picUrl = picUrl.substring(picUrl.lastIndexOf("/"));
            }
            FilmInfo film = new FilmInfo(filmName, director, starring, filmType, filmTime, score, filmIntro, filmReview,picUrl);
            logger.info("[getFilmFromDocument]: " + film);
            return film;
        } catch (Exception e) {
            logger.error("[getFilmFromDocument] ",e);
            return null;
        }
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
        String filePath = PIC_DIR + fileName;
        logger.info("[savePic] " + filePath);
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

    private static final int TIME_OUT = 5000;

    public static byte[] getByte(String uri) throws Exception{
        HttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, TIME_OUT);
        HttpGet get = new HttpGet(uri);
        get.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, TIME_OUT);
        try {
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toByteArray(entity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.getConnectionManager().shutdown();
        }
        return new byte[0];
    }

}
