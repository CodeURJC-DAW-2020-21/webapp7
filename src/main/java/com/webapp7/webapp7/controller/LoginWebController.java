package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginWebController {
    private final UserService userservice;

    public LoginWebController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/checkLogin")
    public String loginUser (@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request){
        User user = userservice.selectByEmail(email);
        if (user == null)
            return "login_error";
        if(user.getPassword().equals(password)){
            HttpSession mysession= request.getSession(true);
            mysession.setAttribute("actualUser",user);
            if (user.getRol().equals(("alumno"))){
                return "redirect:/student";
            }
            if (user.getRol().equals(("administrador"))){
                return "redirect:/admin";
            }
            if (user.getRol().equals(("profesor"))){
                return "redirect:/user_instructor";
            }

        }
        else {
            return "login_error";
        }
        return "/login";
    }
}

