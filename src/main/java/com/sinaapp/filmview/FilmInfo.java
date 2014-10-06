package com.sinaapp.filmview;

public class FilmInfo {

    private String filmName;
    private String director;
    private String starring;
    private String filmType;
    private String filmTime;
    private double score;
    private String filmIntro;
    private String filmReview;
    private String picUrl;
    private int id;

    public FilmInfo(String filmName, String director, String starring, String filmType, String filmTime, double score, String filmIntro, String filmReview, String picUrl, int id) {
        this.filmName = filmName;
        this.director = director;
        this.starring = starring;
        this.filmType = filmType;
        this.filmTime = filmTime;
        this.score = score;
        this.filmIntro = filmIntro;
        this.filmReview = filmReview;
        this.picUrl = picUrl;
        this.id = id;
    }

    public FilmInfo(String filmName, String director, String starring, String filmType, String filmTime, double score, String filmIntro, String filmReview, String picUrl) {
        this.filmName = filmName;
        this.director = director;
        this.starring = starring;
        this.filmType = filmType;
        this.filmTime = filmTime;
        this.score = score;
        this.filmIntro = filmIntro;
        this.filmReview = filmReview;
        this.picUrl = picUrl;
    }

    public String toSQLString() {
        return '\"' + filmName + '\"' + ',' +
                '\"' + director + '\"' + ',' +
                '\"' + starring + '\"' + ',' +
                '\"' + filmType + '\"' + ',' +
                '\"' + filmTime + '\"' + ',' +
                +score + ',' +
                '\"' + filmIntro + '\"' + ',' +
                '\"' + filmReview + '\"' + ',' +
                '\"' + picUrl + '\"'
                ;
    }

    @Override
    public String toString() {
        return '\"' + id + '\"' + ',' +
                '\"' + filmName + '\"' + ',' +
                '\"' + director + '\"' + ',' +
                '\"' + starring + '\"' + ',' +
                '\"' + filmType + '\"' + ',' +
                '\"' + filmTime + '\"' + ',' +
                +score + ',' +
                '\"' + filmIntro + '\"' + ',' +
                '\"' + filmReview + '\"' + ',' +
                '\"' + picUrl + '\"'
                ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getFilmName() {
        return filmName;

    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(String filmTime) {
        this.filmTime = filmTime;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getFilmIntro() {
        return filmIntro;
    }

    public void setFilmIntro(String filmIntro) {
        this.filmIntro = filmIntro;
    }

    public String getFilmReview() {
        return filmReview;
    }

    public void setFilmReview(String filmReview) {
        this.filmReview = filmReview;
    }
}


