package com.webapp7.webapp7.Api;

import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.security.jwt.AuthResponse;
import com.webapp7.webapp7.security.jwt.AuthResponse.Status;
import com.webapp7.webapp7.security.jwt.LoginRequest;
import com.webapp7.webapp7.security.jwt.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class LoginControllerApi {
    @Autowired
    private UserLoginService userService;

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @CookieValue(name = "accessToken", required = false) String accessToken,
            @CookieValue(name = "refreshToken", required = false) String refreshToken,
            @RequestBody LoginRequest loginRequest) {

        return userService.login(loginRequest, accessToken, refreshToken);
    }


    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(
            @CookieValue(name = "refreshToken", required = false) String refreshToken) {

        return userService.refresh(refreshToken);
    }

    @PostMapping("/logout")
    public ResponseEntity<AuthResponse> logOut(HttpServletRequest request, HttpServletResponse response) {

        return ResponseEntity.ok(new AuthResponse(Status.SUCCESS, userService.logout(request, response)));
    }

    @GetMapping("/me")
    public ResponseEntity<User> me(HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

        if(principal != null) {
            return ResponseEntity.ok(service.findByName(principal.getName()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
