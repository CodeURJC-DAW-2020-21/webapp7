package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/instructor")
    public String instructor(Model model){
        List<User> users = userRepository.findByRol("profesor");
        model.addAttribute("users",users);
        return "instructor";
    }


    @GetMapping("/user/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {
        Optional<User> user = userService.findById(id);
        if (user.isPresent() && user.get().getImageFile() != null) {
            Resource file = new InputStreamResource(user.get().getImageFile().getBinaryStream());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                    .contentLength(user.get().getImageFile().length()).body(file);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/admin/user/delete")
    public String deleteUser(@RequestParam("email_delete") String email) throws IOException {
        User user = userService.selectByEmail(email);
        Long id = user.getId();
        userService.delete(id);
        return "redirect:/admin";
    }

}