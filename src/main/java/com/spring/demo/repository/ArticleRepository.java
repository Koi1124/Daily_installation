package com.spring.demo.repository;

import com.spring.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,String> {

    List<Article> findByUserName(String name);
}
