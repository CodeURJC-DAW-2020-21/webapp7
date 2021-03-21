package com.webapp7.webapp7.repository;

import com.webapp7.webapp7.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}


