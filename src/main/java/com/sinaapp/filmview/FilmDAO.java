package com.sinaapp.filmview;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author: fanshen.fs
 * version:1.0  14-10-6
 */
public class FilmDAO extends ActionSupport {

    private static final Logger logger = LogManager.getLogger(FilmDAO.class);

    String filmName;
    String callback;
    String id;
    String query;
    String type;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String delete() {

        Connection sqlconn = SQLConnector.getConnection();
        String tableName = "film";
        try {
            Statement statement = sqlconn.createStatement();

            String sql = "DELETE from "+tableName+" WHERE id="+id;

            logger.info("[FilmDAO ] delete: "+sql);
            // 执行SQL语句
            int rt = statement.executeUpdate(sql);

            if (rt == 1) {
                callback = "true";
            } else {
                callback = "false";
            }
            sqlconn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
}
