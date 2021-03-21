package com.webapp7.webapp7.controller;


import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.User;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    // New user
    @PostMapping("/register")
    public String registerUser (@ModelAttribute User user) throws IOException {

            userService.save(user);

            return "redirect:/login";
        }
    }

