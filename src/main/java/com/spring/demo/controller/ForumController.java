package com.spring.demo.controller;


import com.spring.demo.entity.Article;
import com.spring.demo.entity.User;
import com.spring.demo.service.ArticleServiceImp;
import com.spring.demo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ForumController {
    @Autowired
    ArticleServiceImp articleServiceImp;
    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping("/forum")
    public String toForum(Map<String,Object> map) {
        map.put("articlesByDate",articleServiceImp.allArticleByDate());
        map.put("articlesByCount",articleServiceImp.allArticleByCount());
        return "ttzj/testForum";
    }

    @RequestMapping("/forum/ask")
    public String toAsk() {
        return "ttzj/testAsk";
    }

    @PostMapping("/forum/save")
    public String addArtcile(Article article, Map<String, Object> map) {
        articleServiceImp.addArticle(article);
        return "redirect:/main.html";
    }

    @RequestMapping("/forum/detail")
    public String toDetail(String id, Map<String, Object> map) {
        Article article=articleServiceImp.findById(id);
        map.put("article",article);
        User user=userServiceImp.findById(article.getUserName());
        map.put("writer",user);
        return "ttzj/testDetail";
    }

}
