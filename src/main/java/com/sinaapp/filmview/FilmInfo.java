package com.sinaapp.filmview;

/*
  电影信息封装类
  包括：电影名，导演，主角姓名，电影类型，上映时间，电影评分，电影简介，电影评语
 */
public class FilmInfo {

        private String filmName ;
        private String director;
        private String starring;
        private String filmType;
        private String filmTime;
        private double score;
        private String filmIntro;
        private String filmReview;

        public FilmInfo(String filmName, String director, String starring, String filmType, String filmTime, double score, String filmIntro, String filmReview) {
            this.filmName = filmName;
            this.director = director;
            this.starring = starring;
            this.filmType = filmType;
            this.filmTime = filmTime;
            this.score = score;
            this.filmIntro = filmIntro;
            this.filmReview = filmReview;
        }

        @Override
        public String toString() {
            return  '\"'+filmName + '\"' +','+
                    '\"'+director + '\"' +','+
                    '\"'+starring + '\"' +','+
                    '\"'+filmType + '\"' +','+
                    '\"'+filmTime + '\"' +','+
                    + score  +','+
                    '\"'+filmIntro + '\"' +','+
                    '\"'+filmReview + '\"'
                    ;
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


