package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/comments")
public class CommentControllerApi {

    @Autowired
    private com.webapp7.webapp7.Service.CommentService commentService;

    @JsonView(CommentBasic.class)
    @GetMapping("/")
    public ResponseEntity<Collection<Comment>> getComments() {
        List<Comment> comments = commentService.listAllComment();
        if (!comments.isEmpty()) {
            return ResponseEntity.ok(comments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(CommentBasic.class)
    @PostMapping("/")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return ResponseEntity.created(fromCurrentRequest().path("/").buildAndExpand(comment.getId()).toUri()).body(comment);
    }

    interface CommentBasic extends Comment.Basic {
    }
}
