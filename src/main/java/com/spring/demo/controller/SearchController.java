package com.spring.demo.controller;

import com.spring.demo.entity.Article;
import com.spring.demo.entity.User;
import com.spring.demo.service.ArticleServiceImp;
import com.spring.demo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    ArticleServiceImp articleServiceImp;


    @RequestMapping("/search")
    public String search(String kword, Map<String,Object> map) {
        List<User> users=userServiceImp.findByIdLike("%"+kword+"%");
        map.put("users",users);
        List<Article> articles=articleServiceImp.findByTitleOrContent("%"+kword+"%");
        map.put("articles",articles);
        map.put("keyword",kword);
        int count=users.size()+articles.size();
        map.put("count",count);
        return "ttzj/searchResult";
    }
}
