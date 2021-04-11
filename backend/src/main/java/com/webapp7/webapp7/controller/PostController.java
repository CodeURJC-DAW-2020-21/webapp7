package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.model.User;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller("/blog")
public class PostController {

    @Autowired
    private com.webapp7.webapp7.Service.PostService service;
    @Autowired
    private com.webapp7.webapp7.Service.CourseService courseService;
    @Autowired
    private com.webapp7.webapp7.Service.UserService userService;

    /**
     *
     * @param model
     * @param title
     * @param description
     * @param imageField
     * @return
     * @throws IOException
     */
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

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String login(Model model) {
        List<Post> posts =  service.listPosts();
        model.addAttribute("posts",posts);
        List<Course> courses = courseService.listCourse();
        model.addAttribute("courses_size",courses.size());
        List<User> users = userService.findAllUsers();
        List<User> instructors = new ArrayList<>();
        List<User> students = new ArrayList<>();
        int count =0;
        while (!users.isEmpty() && count<users.size()){
            if(users.get(count).getRol().equals("profesor")){
                instructors.add(users.get(count));
            }
            if(users.get(count).getRol().equals("alumno")){
                students.add(users.get(count));
            }
            count++;
        }
        model.addAttribute("instructors",instructors.size());
        model.addAttribute("students",students.size());
        model.addAttribute("courses_size",courses.size());
        return "index";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/blog")
    public String blog(Model model){
        ArrayList<Post> posts=service.findPost(PageRequest.of(0, 3));
        model.addAttribute("posts", posts);
        List<Post> restOfPosts =  service.listPosts();
     /*List<Post> trocito = new ArrayList<>();
        for (int i = 2; i<restOfPosts.size();i++) {
            trocito.add(restOfPosts.get(i));
        }
        if (!trocito.isEmpty()) {
            model.addAttribute("trocito", trocito);
        }

         */
        restOfPosts.remove(0);
        restOfPosts.remove(0);
        restOfPosts.remove(0);
        if (!restOfPosts.isEmpty()) {
            model.addAttribute("restOfPosts", restOfPosts);
        }
        return "blog";
    }

    /**
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/post/{id}")
    public String showPost(Model model, @PathVariable long id) {
        Post post = service.findById(id).orElseThrow();
        model.addAttribute("post", post);
        List<Post> posts =  service.listPosts();
        model.addAttribute("posts",posts);



        return "blog-single";
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
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

    /**
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/post/post/{id}")
    public String showPostlinked(Model model, @PathVariable long id) {
        Post post = service.findById(id).orElseThrow();
        model.addAttribute("post", post);
        List<Post> posts =  service.listPosts();
        model.addAttribute("posts",posts);
        return "blog-single";
    }





}
