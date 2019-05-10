package com.spring.demo.service;

import com.spring.demo.entity.Article;
import com.spring.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImp implements  ArticleService{
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> allArticleByDate() {
        Sort sort = new Sort(Sort.Direction.DESC,"date");
        return articleRepository.findAll(sort);
    }

    @Override
    public List<Article> allArticleByCount() {
        Sort sort = new Sort(Sort.Direction.DESC,"count");
        return articleRepository.findAll(sort);
    }

    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article findById(String id) {
        Optional<Article> byId = articleRepository.findById(id);
        return byId.get();
    }

    @Override
    public void removeArticle(String id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> articleByUserName(String name) {
        return articleRepository.findByUserName(name);
    }
}
