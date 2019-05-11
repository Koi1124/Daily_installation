package com.spring.demo.service;

import com.spring.demo.entity.Comment;
import com.spring.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> allDirectComment(String articleId) {
        return commentRepository.findByReplyUserNameIsNullAndArticleId(articleId);
    }

    @Override
    public HashMap<String, List<Comment>> allSubComment(String articleId) {
        List<Comment> byReplyUserNameIsNotNull = commentRepository.findByReplyUserNameIsNotNullAndArticleId(articleId);
        HashMap<String, List<Comment>> map=new HashMap<>();
        for (Comment comment: byReplyUserNameIsNotNull) {
            if (map.get(comment.getParentCommentId())==null) {
                List<Comment> list=new ArrayList<>();
                list.add(comment);
                map.put(comment.getParentCommentId(),list);
            }else {
                List<Comment> list=map.get(comment.getParentCommentId());
                list.add(comment);
                map.put(comment.getParentCommentId(),list);
            }
        }
        return map;
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
