package com.spring.demo.controller;


import com.spring.demo.entity.Article;
import com.spring.demo.entity.Comment;
import com.spring.demo.entity.User;
import com.spring.demo.service.ArticleServiceImp;
import com.spring.demo.service.CommentServiceImp;
import com.spring.demo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ForumController {
    @Autowired
    ArticleServiceImp articleServiceImp;
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    CommentServiceImp commentServiceImp;

    private String articleId;

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
        return "redirect:";
    }

    @RequestMapping("/forum/detail")
    public String toDetail(String id, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        Article article=articleServiceImp.findById(id);
        article.setCount(article.getCount()+1);
        article=articleServiceImp.updateArticle(article);
        map.put("article",article);
        User user=userServiceImp.findById(article.getUserName());
        map.put("writer",user);

        List<Comment> comments=commentServiceImp.allDirectComment(id);
        HashMap<String,List<Comment>> subComments=commentServiceImp.allSubComment(id);

        map.put("comments",comments);
        map.put("subComments",subComments);

        articleId=id;
        return "ttzj/testDetail";
    }

    @PostMapping("/forum/detail/comment")
    public String comment(Comment comment,RedirectAttributes redirectAttributes) {
        commentServiceImp.addComment(comment);
        redirectAttributes.addAttribute("id",articleId);
        return "redirect:";
    }

    @PostMapping("/forum/detail/reply")
    public String reply(Comment comment,RedirectAttributes redirectAttributes) {
        commentServiceImp.addComment(comment);
        redirectAttributes.addAttribute("id",articleId);
        return "redirect:";
    }


}
