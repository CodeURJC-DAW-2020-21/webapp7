package com.webapp7.webapp7.controller;

import java.util.List;

import com.webapp7.webapp7.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.webapp7.webapp7.model.Comment;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/student/comment/createNew")
    public String addComment(@RequestParam String name, @RequestParam String opinion){
        Comment comment = new Comment();
        comment.setName(name);
        comment.setComment(opinion);
        commentService.save(comment);
        return "redirect:/student";
    }

    @GetMapping("/about")
    public String about(Model model) {
        List<Comment> comments = commentService.listAllComment();
        model.addAttribute("comments", comments);
        return "about";
    }

}
