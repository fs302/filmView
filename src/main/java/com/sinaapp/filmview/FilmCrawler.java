package com.sinaapp.filmview;

import com.opensymphony.xwork2.ActionSupport;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * Author: fanshen.fs
 * version:1.0  14-10-1
 */
public class FilmCrawler extends ActionSupport {

    String url;
    String filmHtmlDoc;

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

    public String fetch() throws IOException {
        String filmUrl =  URLDecoder.decode(url, "UTF-8");
        System.out.println(url+"->"+filmUrl);
        Connection conn = Jsoup.connect(filmUrl);
        Document doc = conn.get();
//        SaeFetchUrl fetch = new SaeFetchUrl();
//        String html = fetch.fetch(filmUrl);
//        Document doc = Jsoup.parse(html);
        filmHtmlDoc = doc.text().toString();
        return SUCCESS;
   }

}
