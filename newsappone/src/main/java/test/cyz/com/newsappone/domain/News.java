package test.cyz.com.newsappone.domain;

import java.util.Date;

/**
 * Created by M on 2016/11/23.
 */
public class News {


    private String title;
    private String content;
    private String author;
    private String time;

    public News(String author, String content, String time, String title) {
        this.author = author;
        this.content = content;
        this.time = time;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
