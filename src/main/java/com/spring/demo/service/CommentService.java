package com.spring.demo.service;

import com.spring.demo.entity.Comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommentService {

    List<Comment> allDirectComment(String articleId);

    HashMap<String, List<Comment>> allSubComment(String articleId);

    Comment addComment(Comment comment);

}
