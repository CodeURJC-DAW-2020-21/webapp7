package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserControllerApi {

    interface UserBasic extends User.Basic {
    }

    @Autowired
    private com.webapp7.webapp7.Service.UserService userService;

    @JsonView(UserBasic.class)
    @GetMapping("/")
    public ResponseEntity<Collection<User>> getUsers() {
        List<User> users = userService.findAllUsers();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(UserBasic.class)
    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        //we need to change this structure due to passwordEncoder
        userService.save(user);
        return ResponseEntity.created(fromCurrentRequest().path("/").buildAndExpand(user.getId()).toUri()).body(user);
    }

    @JsonView(UserBasic.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deletePost(@PathVariable long id) throws IOException{
        User user = userService.findById(id).orElse(null);
        if (user != null) {
            user.setCourse(null);
            user.setFinishedMaterials(null);
            userService.delete(id);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
