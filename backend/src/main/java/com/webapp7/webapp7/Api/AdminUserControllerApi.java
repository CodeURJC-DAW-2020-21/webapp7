package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.Service.ImageService;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.model.User;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserControllerApi {

    interface UserBasic extends User.Basic {}
    private static final String USERS_FOLDER = "users";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private com.webapp7.webapp7.Service.CourseService courseService;

    @Autowired
    private com.webapp7.webapp7.Service.UserService userService;

    @Autowired
    private ImageService imgService;

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
        String passwordAux = user.getPassword();
        String password = passwordEncoder.encode(passwordAux);
        user.setPassword(password);
        userService.save(user);
        return ResponseEntity.created(fromCurrentRequest().path("/").buildAndExpand(user.getId()).toUri()).body(user);
    }
    @JsonView(UserBasic.class)
    @PostMapping("/{id}/image")
    public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
            throws IOException {

        User user = userService.findById(id).orElseThrow(null);

        if (user != null) {

            URI location = fromCurrentRequest().build().toUri();

            if (!imageFile.isEmpty()) {
                user.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
                user.setImage(true);
            }
            userService.save(user);

            imgService.saveImage(USERS_FOLDER, user.getId(), imageFile);

            return ResponseEntity.created(location).build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @JsonView(UserBasic.class)
    @GetMapping("/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws MalformedURLException {

        return this.imgService.createResponseFromImage(USERS_FOLDER, id);
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

    @JsonView(UserBasic.class)
    @PutMapping("/{idUser}/course/{idCourse}")
    public ResponseEntity<User> addUserToCourse(@PathVariable long idUser, @PathVariable long idCourse) throws IOException{
        System.out.println("He entrado en addUserToCourse");
        User user = userService.findById(idUser).orElse(null);
        if (user != null) {
            System.out.println("El usuario no está a null");
            Optional<Course> getCourse = courseService.findById(idCourse);
            if (getCourse!=null){
                System.out.println("No está en ningún curso");
                Course course = getCourse.get();
                user.setCourse(course);
                userService.save(user);
            }
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(UserBasic.class)
    @DeleteMapping("/{idUser}/course/{idCourse}")
    public ResponseEntity<User> deleteUserFromCourse(@PathVariable long idUser, @PathVariable long idCourse) throws IOException{
        User user = userService.findById(idUser).orElse(null);
        if (user != null) {
            Optional<Course> getCourse = courseService.findById(idCourse);
            if (user.getCourse()!=null){
                user.setCourse(null);
                userService.save(user);
            }
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
