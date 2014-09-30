package com.sinaapp.filmview;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author: fanshen.fs
 * version:1.0  14-9-30
 */
public class Search extends ActionSupport {

    String type;
    String query;
    String Context;

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String execute() {
        Context = query + type;

        return SUCCESS;
    }

    public FilmInfo getFilmInfo(String query, String type) {


        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_filmView";
        String user = "yoykwo0k5x";
        String password = "k2x0zyx4m31lwz1hjiylxyhjjm20h5mzlxmmlxh5";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement statement = conn.createStatement();

            String sql = "select";
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
