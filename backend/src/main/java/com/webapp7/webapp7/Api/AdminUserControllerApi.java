package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.Service.ImageService;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.model.User;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.security.Principal;
import java.sql.SQLException;
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
    @GetMapping("/me")
    public ResponseEntity<User> me(HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

        if(principal != null) {
            return ResponseEntity.ok(userService.findByName(principal.getName()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @JsonView(AdminCourseControllerApi.CourseBasic.class)
    @GetMapping("/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws MalformedURLException, SQLException {
        Optional<User> user = userService.findById(id);
        if (user.isPresent() && user.get().getImageFile() != null) {

            Resource file = new InputStreamResource(user.get().getImageFile().getBinaryStream());

            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                    .contentLength(user.get().getImageFile().length()).body(file);

        } else {
            return ResponseEntity.notFound().build();
        }

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
