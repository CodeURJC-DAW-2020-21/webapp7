package com.webapp7.webapp7.repository;

import com.webapp7.webapp7.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}