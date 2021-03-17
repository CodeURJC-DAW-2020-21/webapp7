package com.webapp7.webapp7.Service;

import java.util.List;
import java.util.Optional;

import com.webapp7.webapp7.model.Comment;
import com.webapp7.webapp7.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

    @Autowired
    @Qualifier("commentRepository")
    private CommentRepository commentRepository;

    public List<Comment> listAllComment() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findById(long id) {
        return commentRepository.findById(id);
    }

    public boolean exist(long id) {
        return commentRepository.existsById(id);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void delete(long id) {
        commentRepository.deleteById(id);
    }

}