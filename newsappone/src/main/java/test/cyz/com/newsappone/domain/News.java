package test.cyz.com.newsappone.domain;

import java.util.Date;

/**
 * Created by M on 2016/11/23.
 */
public class News {


    private String title;
    private String content;
    private String author;
    private Date time;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
