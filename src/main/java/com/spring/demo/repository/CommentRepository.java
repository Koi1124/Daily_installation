package com.spring.demo.repository;

import com.spring.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,String> {
}
