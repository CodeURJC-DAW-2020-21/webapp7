package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.model.Comment;
import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/register")
public class RegisterControllerApi {

    interface RegisterBasic extends User.Basic {}

    @Autowired
    private com.webapp7.webapp7.Service.UserService userService;

    @JsonView(RegisterBasic.class)
    @GetMapping("/")
    public ResponseEntity<Collection<User>> getUsers() {
        List<User> users = userService.findAllUsers();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(RegisterBasic.class)
    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        //we need to change this structure due to passwordEncoder
        userService.save(user);
        return ResponseEntity.created(fromCurrentRequest().path("/").buildAndExpand(user.getId()).toUri()).body(user);
    }
}
