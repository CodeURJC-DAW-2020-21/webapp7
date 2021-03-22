package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.IOException;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser (@ModelAttribute User user) throws IOException {
        String email = user.getEmail();
        User userAux = userService.selectByEmail(email);
        if (userAux == null){
            userService.save(user);
            return "redirect:/admin";
        }
        else{
            return "redirect:/admin";
        }
    }
}

