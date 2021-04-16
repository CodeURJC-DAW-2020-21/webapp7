package com.webapp7.webapp7.Api;

import com.webapp7.webapp7.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginWebControllerApi {
    @Autowired
    private UserService userService;



}
