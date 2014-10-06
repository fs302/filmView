package com.sinaapp.filmview;

import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.opensymphony.xwork2.ActionSupport;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author: fanshen.fs
 * version:1.0  14-10-6
 */
public class FilmSaver extends ActionSupport{

    private static final Logger logger =  LoggerFactory.getLogger(FilmSaver.class);

    FilmInfo filmInfo;
    String url;
    String saved;

    public FilmInfo getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSaved() {
        return saved;
    }

    public void setSaved(String saved) {
        this.saved = saved;
    }

    public String saveFilm() throws IOException {

        if (url == null) {
            saved = "false";
            return SUCCESS;
        }

        String filmUrl = URLDecoder.decode(url, "UTF-8");
        logger.info(filmUrl);
        Connection conn = Jsoup.connect(filmUrl);
        Document doc = conn.get();
        filmInfo = FilmCrawler.getFilmFromDocument(doc);

        saved = "false";
        String tableName = "film";
        java.sql.Connection sqlconn = SQLConnector.getConnection();
        if (filmInfo != null && sqlconn != null) {

            if (CheckIfNotExist(sqlconn, tableName, filmInfo)){
                try {
                    Statement statement = sqlconn.createStatement();

                    String sql = "INSERT INTO " + tableName + " VALUES (" +
                            filmInfo.toString() + ")";

                    // 执行SQL语句
                    int rt = statement.executeUpdate(sql);

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

                logger.info("[CHeckIfNotExist]: "+sql);

                // 执行SQL语句
                ResultSet rs = statement.executeQuery(sql);
                logger.info("[CHeckIfNotExist]: "+!rs.next());
                return !rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
