package com.spring.demo.repository;

import com.spring.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String> {


    List<Comment> findByReplyUserNameIsNullAndArticleId(String articleId);

    List<Comment> findByReplyUserNameIsNotNullAndArticleId(String articleId);

}
