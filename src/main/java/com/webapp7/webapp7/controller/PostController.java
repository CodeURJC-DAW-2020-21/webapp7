package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;


@Controller("/blog")
public class PostController {

    @Autowired
    private PostService service;

    /*@GetMapping("/")
    public String showBooks(Model model) {

        model.addAttribute("blogs", service.findAll());

        return "blogs";
    }
    @GetMapping("/posts/{id}")
    public String showBook(Model model, @PathVariable long id) {

        Optional<Post> post = service.findById(id);
        if (post.isPresent()) {
            model.addAttribute("book", post.get());
            return "post";
        } else {
            return "posts";
        }

    }

     */

    @PostMapping("/admin/newBlog")
    public String addPost(@RequestParam String title, @RequestParam String description){
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);

        return "redirect:/admin ";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        List<Post> posts =  service.listPosts();
        model.addAttribute("posts",posts);

        return "blog";
    }




}
