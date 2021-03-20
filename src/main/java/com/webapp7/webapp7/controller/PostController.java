package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.service.PostService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Controller("/blog")
public class PostController {

    @Autowired
    private PostService service;


    @PostMapping("/admin/post/createNew")
    public String addPost(Model model, @RequestParam String title, @RequestParam String description, MultipartFile imageField) throws IOException {
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);

        if (!imageField.isEmpty()) {
            post.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
            post.setImage(true);
        }

        model.addAttribute("postId", post.getId());

        service.save(post);
        return "redirect:/admin";
    }

    @GetMapping("/index")
    public String login(Model model) {
        List<Post> posts =  service.listPosts();
        model.addAttribute("posts",posts);
        return "index";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        List<Post> posts =  service.listPosts();
        model.addAttribute("posts",posts);
        return "blog";
    }


    @GetMapping("/post/{id}")
    public String showPost(Model model, @PathVariable long id) {

        Post post = service.findById(id).orElseThrow();
        model.addAttribute("post", post);

        List<Post> posts =  service.listPosts();
        model.addAttribute("posts",posts);

        return "blog-single";
    }
    @GetMapping("/post/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {

        Optional<Post> post = service.findById(id);
        if (post.isPresent() && post.get().getImageFile() != null) {

            Resource file = new InputStreamResource(post.get().getImageFile().getBinaryStream());

            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                    .contentLength(post.get().getImageFile().length()).body(file);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/post/post/{id}")
    public String showPostlinked(Model model, @PathVariable long id) {

        Post post = service.findById(id).orElseThrow();
        model.addAttribute("post", post);

        List<Post> posts =  service.listPosts();
        model.addAttribute("posts",posts);

        return "blog-single";
    }





}
