package com.spring.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ttzj_article")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Article {
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String articleId;

    @Column(nullable = false,name = "title")
    private String title;

    @Column(nullable = false,name = "userName")
    private String userName;

    @Column(nullable = false,name = "date")
    private Date date;

    @Column(nullable = false,name = "type")
    private int type;

    @Column(nullable = false,name = "content")
    private String content;

    @Column(nullable = false,name = "count")
    private int count;

    public void setDate(Date date) {
        this.date = date;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCount() {
        return count;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }
}
