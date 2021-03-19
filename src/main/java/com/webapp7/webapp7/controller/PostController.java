package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.SQLException;
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

    /*
     @GetMapping("/books/{id}")
	public String showBook(Model model, @PathVariable long id) {

		Optional<Book> book = service.findById(id);
		if (book.isPresent()) {
			model.addAttribute("book", book.get());
			return "book";
		} else {
			return "books";
		}

	}*/
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
    //{{blog_page}}
    //...
    //{{/blog_page}
    /*@GetMapping("/post/post/{id}")
    public String showPostlinked(Model model, @PathVariable long id) {

        Post post = service.findById(id).orElseThrow();
        model.addAttribute("post", post);

        List<Post> posts =  service.listPosts();
        model.addAttribute("posts",posts);

        return "blog-single";
    }
    */
/*
    @GetMapping("/blog-single")
    public String blog_single(Model model){
        List<Post> posts =  service.listPosts();
        model.addAttribute("blog_page",posts);

        return "blog-single";
    }
    */





}
