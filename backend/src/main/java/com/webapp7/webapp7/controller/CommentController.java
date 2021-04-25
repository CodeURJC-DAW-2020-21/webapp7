package com.webapp7.webapp7.controller;

import java.util.ArrayList;
import java.util.List;

import com.webapp7.webapp7.Service.CommentService;
import com.webapp7.webapp7.Service.CourseService;
import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.webapp7.webapp7.model.Comment;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;


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
        return "about";
    }

}
