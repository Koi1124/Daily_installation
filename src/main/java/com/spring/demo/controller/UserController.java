package com.spring.demo.controller;

import com.spring.demo.entity.Article;
import com.spring.demo.service.ArticleServiceImp;
import com.spring.demo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    ArticleServiceImp articleServiceImp;

    @RequestMapping("/userInfo")
    public String user(String name, HttpSession session, Map<String,Object> map){
        List<Article> list = articleServiceImp.articleByUserName(name);
        map.put("user",userServiceImp.findById(name));
        map.put("articleAmount",list.size());
        map.put("articles",list);
        if (session.getAttribute("user").equals(name)) {
            return "ttzj/testMy";
        }else {
            return "ttzj/testMy";
        }
    }
}
