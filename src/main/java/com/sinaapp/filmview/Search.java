package com.sinaapp.filmview;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: fanshen.fs
 * version:1.0  14-9-30
 */
public class Search extends ActionSupport {

    String type;
    String query;
    String Context;

    List<FilmInfo> filmInfos;

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

    public List<FilmInfo> getFilmInfos() {
        return filmInfos;
    }

    public void setFilmInfos(List<FilmInfo> filmInfos) {
        this.filmInfos = filmInfos;
    }

    public String execute() {
        if (query != null && query != ""){
            System.out.println("query:"+query+"\t type"+type);
            filmInfos = getFilmInfo(query, type);
        }
        else {
            List<FilmInfo> queryResult = getFilmInfo("","filmName");
            filmInfos = queryResult.subList(0,20);
        }
        for(FilmInfo f:filmInfos) {
            System.out.println(f.getFilmName());
        }
        return SUCCESS;
    }

    public static List<FilmInfo> getFilmInfo(String query, String type) {

        Connection conn = getConnection();
        if (conn != null){
            try {
                Statement statement = conn.createStatement();
                String tableName = "film";
                String sql;
                if (!type.equals("all")) {
                    sql = "SELECT * FROM "+tableName+" WHERE "+type+" LIKE "+"\'%"+query+"%\'";
                    System.out.println(sql);
                }
                else {
                    sql = "SELECT * FROM "+tableName+" WHERE "+"filmName"+" LIKE "+"\'%"+query+"%\'"
                            +" OR "+"director"+" LIKE "+"\'%"+query+"%\'"
                            +" OR "+"starring"+" LIKE "+"\'%"+query+"%\'"
                            +" OR "+"filmType"+" LIKE "+"\'%"+query+"%\'"
                            +" OR "+"filmIntro"+" LIKE "+"\'%"+query+"%\'"
                            +" OR "+"filmReview"+" LIKE "+"\'%"+query+"%\'"
                    ;
                }
                ResultSet rs = statement.executeQuery(sql);

                List<FilmInfo> result = new ArrayList<FilmInfo>();
                while(rs.next()) {
                    String filmName = rs.getString("filmName");
                    String director = rs.getString("director");
                    String[] starringContent = rs.getString("starring").split(":");
                    String starring="";
                    if (starringContent != null && starringContent.length>1) {
                        starring = starringContent[1];
                    }
                    else {
                        starring = rs.getString("starring");
                    }
                    String filmType = rs.getString("filmType");
                    String filmTime = rs.getString("filmTime");
                    Double score = Double.parseDouble(rs.getString("score"));
                    String filmIntro = rs.getString("filmIntro");
                    String filmReview = rs.getString("filmReview");
                    FilmInfo filmInfo = new FilmInfo(filmName, director, starring, filmType, filmTime, score, filmIntro, filmReview);
                    result.add(filmInfo);
                }
                conn.close();
                return result;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Connection getConnection(){
        Connection conn = null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_filmView";
        String user = "yoykwo0k5x";
        String password = "k2x0zyx4m31lwz1hjiylxyhjjm20h5mzlxmmlxh5";

        /*
        String url = "jdbc:mysql://127.0.0.1:3306/filmInfoSystem";
        String user = "root";
        String password = "root";
        */
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user, password);
        } catch (Exception e) {
            System.out.println("数据库连接失败:"+e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args){
        List<FilmInfo> queryResult = getFilmInfo("","filmName");
        for(FilmInfo f:queryResult) {
            System.out.println(f.toString());
        }
    }
}
