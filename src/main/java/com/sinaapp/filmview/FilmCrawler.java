package com.sinaapp.filmview;

import com.opensymphony.xwork2.ActionSupport;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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

            FilmInfo film = new FilmInfo(filmName, director, starring, filmType, filmTime, score, filmIntro, filmReview);
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
                if (rs.next()) {
                    return false;
                }
                else {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
