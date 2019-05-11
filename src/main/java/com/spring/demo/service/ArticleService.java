package com.spring.demo.service;

import com.spring.demo.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> allArticleByDate();

    List<Article> allArticleByCount();

    Article addArticle(Article article);

    Article findById(String id);

    List<Article> articleByUserName(String name);

    void removeArticle(String id);

    Article updateArticle(Article article);
}
