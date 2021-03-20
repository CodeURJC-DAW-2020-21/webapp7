package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.User;
 import com.webapp7.webapp7.repository.UserRepository;
import com.webapp7.webapp7.Service.DataBaseInitializer;
import com.webapp7.webapp7.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginWebController {

    /*@RequestMapping("/login")
    public String login() {
        return "login";
    }*/


    private DataBaseInitializer  dataBaseInitializer;
    @Autowired
    UserService userservice;
    @PostMapping("/login")
    public String login( String email,  String password){
        List<User> userList = userservice.findAll();
        for(int i=0; i<userList.size(); i++) {
            if (userList.get(i).getEmail().equals(email) && userList.get(i).getPassword().equals(password) ) {
                if (userList.get(i).getRol().equals("admin")) {
                    return "redirect: /admin";

                }
                if (userList.get(i).getRol().equals("alumno")) {
                    return "redirect: /student";
                }
                if (userList.get(i).getRol().equals("profesor")) {
                    return "redirect: /user_instructor";

                }
            }
        }


        return "redirect: /index";

    }
    }


