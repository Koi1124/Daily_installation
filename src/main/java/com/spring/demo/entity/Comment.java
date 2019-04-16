package com.spring.demo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ttzj_comment")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Comment {

    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String commentId;

    @Column(nullable = false,name = "articleId")
    private String articleId;

    @Column(nullable = false,name = "userName")
    private String userName;

    @Column(nullable = false,name = "content")
    private String content;

    @Column(nullable = false,name = "date")
    private Date date;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
