package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.repository.UserRepository;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser (@ModelAttribute User user, MultipartFile imageField) throws IOException {
        String email = user.getEmail();
        String name= user.getName();
        String password= user.getPassword();

        if (!imageField.isEmpty()) {
            user.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
            user.setImage(true);
        }
        //Blob imageFile= user.getImageFile();


        //user.setImage(true);
        //user.setImageFile(imageFile);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);



        User userAux = userService.selectByEmail(email);
        if (userAux == null){
            userService.save(user);
            return "redirect:/admin";
        }
        else{
            return "redirect:/admin";
        }
    }

    public void setUserImage(User user, String classpathResource) throws IOException {
        user.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        user.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
    }


}

