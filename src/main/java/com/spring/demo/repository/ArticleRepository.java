package com.spring.demo.repository;

import com.spring.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,String> {
}
