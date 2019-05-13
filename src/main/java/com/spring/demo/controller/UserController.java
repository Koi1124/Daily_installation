package com.spring.demo.controller;

import com.spring.demo.entity.Article;
import com.spring.demo.entity.Configuration;
import com.spring.demo.entity.User;
import com.spring.demo.service.ArticleServiceImp;
import com.spring.demo.service.ConfigurationServiceImp;
import com.spring.demo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    ArticleServiceImp articleServiceImp;
    @Autowired
    ConfigurationServiceImp configurationServiceImp;

    private String userName;

    @RequestMapping("/userInfo")
    public String user(String name, HttpSession session, Map<String,Object> map){
        List<Article> list = articleServiceImp.articleByUserName(name);
        map.put("user",userServiceImp.findById(name));
        map.put("articleAmount",list.size());
        map.put("articles",list);
        List<Configuration> cList = configurationServiceImp.findConfigurationByUserName(name);
        session.setAttribute("configurations", cList);
        userName=name;
        if (session.getAttribute("user").equals(name)) {
            return "ttzj/testMy";
        }else {
            return "ttzj/testMy";
        }
    }


    @PostMapping("/userInfo/changePW")
    public String change(User user, RedirectAttributes redirectAttributes) {
        userServiceImp.updateUser(user);
        redirectAttributes.addAttribute("name",userName);
        return "redirect:";
    }

    @RequestMapping("/admin")
    public String admin(Map<String ,Object> map) {
        List<User> users=userServiceImp.allUser();
        map.put("users",users);
        List<Article> articles=articleServiceImp.allArticleByDate();
        map.put("articles",articles);
        return "ttzj/admin";
    }

    @PostMapping("/admin/login")
    public String adminLogin(User user,Map<String,Object> map) {
        if (user.getName().equals("admin")&& user.getPassword().equals("tiantianzhuangji")) {
            return "redirect:";
        }else {
            map.put("msg","用户名密码错误");
            return "ttzj/testLogin";
        }
    }

    @PostMapping("/admin/deleteArticle")
    public String deleteArticle(String articleId) {
        articleServiceImp.removeArticle(articleId);
        return "redirect:";
    }

    @PostMapping("/admin/deleteUser")
    public String deleteUser(String name) {
        userServiceImp.removeUserByUserId(name);
        return "redirect:";
    }


}
