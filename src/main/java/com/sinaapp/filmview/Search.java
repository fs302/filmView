package com.sinaapp.filmview;

import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: fanshen.fs
 * version:1.0  14-9-30
 */
public class Search extends ActionSupport {

    private static final Logger logger = LoggerFactory.getLogger(Search.class);

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
            logger.info("query:" + query + ", type:" + type);
            filmInfos = getFilmInfo(query, type);
        }
        else {
            List<FilmInfo> queryResult = getFilmInfo("","filmName");
            if (queryResult != null && queryResult.size()>10){
                filmInfos = queryResult.subList(0,10);
            }
            else {
                filmInfos = queryResult;
            }

        }

        return SUCCESS;
    }

    public static List<FilmInfo> getFilmInfo(String query, String type) {

        Connection conn = SQLConnector.getConnection();
        if (conn != null){
            try {
                Statement statement = conn.createStatement();
                String tableName = "film";
                String sql;
                if (!type.equals("all")) {
                    sql = "SELECT * FROM "+tableName+" WHERE "+type+" LIKE "+"\'%"+query+"%\'";
                    logger.info(sql);
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
                    String filmName = tagQuery(rs.getString("filmName"),query);
                    String director = tagQuery(rs.getString("director"),query) ;
                    String[] starringContent = rs.getString("starring").split(":");
                    String starring="";
                    if (starringContent != null && starringContent.length>1) {
                        starring = tagQuery(starringContent[1],query) ;
                    }
                    else {
                        starring = tagQuery(rs.getString("starring"),query);
                    }
                    String filmType = tagQuery(rs.getString("filmType"),query) ;
                    String filmTime = rs.getString("filmTime") ;
                    Double score = Double.parseDouble(rs.getString("score"));
                    String filmIntro = tagQuery(rs.getString("filmIntro"),query) ;
                    String filmReview =  rs.getString("filmReview");
                    String picUrl = rs.getString("picUrl");
                    if (picUrl != null) {
                        picUrl = picUrl.substring(picUrl.lastIndexOf('/'));
                    }
                    FilmInfo filmInfo = new FilmInfo(filmName, director, starring, filmType, filmTime, score, filmIntro, filmReview,picUrl);
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

    public static String tagQuery(String content, String query) {
        if (query.length()>1){
            return content.replaceAll(query,"<b>"+query+"</b>");
        }
        return content;
    }

    public static void main(String[] args){
        List<FilmInfo> queryResult = getFilmInfo("","filmName");
        for(FilmInfo f:queryResult) {
            System.out.println(f.toString());
        }
    }
}
