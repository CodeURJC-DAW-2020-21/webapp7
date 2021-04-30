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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/courses")
public class AdminCourseControllerApi {

    interface CourseBasic extends Course.Basic {}
    private static final String COURSES_FOLDER = "courses";

    @Autowired
    private com.webapp7.webapp7.Service.CourseService courseService;

    @Autowired
    private com.webapp7.webapp7.Service.UserService userService;

    @Autowired
    private ImageService imgService;

    @JsonView(CourseBasic.class)
    @GetMapping("/")
    public ResponseEntity<Collection<Course>> getCourses() {
        List<Course> courses = courseService.listCourse();
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(CourseBasic.class)
    @PostMapping("/")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        courseService.save(course);
        return ResponseEntity.created(fromCurrentRequest().path("/").buildAndExpand(course.getId()).toUri()).body(course);
    }

    @JsonView(CourseBasic.class)
    @PutMapping("/{id}")
        public ResponseEntity<Course> replaceCourse(@PathVariable long id,
                                              @RequestBody Course newCourse) {
        Course course = courseService.findById(id).orElse(null);
        if (course != null) {
            newCourse.setId(id);
            courseService.save(newCourse);
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(CourseBasic.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable long id) throws IOException {
        Course course = courseService.findById(id).orElseThrow(null);
        List<User> users = course.getStudents();
        User user;
        for ( int i=1 ; i<users.size() ; i++ ) {
            user = users.get(i);
            if (user.getCourse()!=null && user.getCourse().getId()==id){
                user.setCourse(null);
                userService.save(user);
            }
        }
        if (course != null ) {
            courseService.deleteById(id);

            if(course.getImageFile() != null) {
                this.imgService.deleteImage(COURSES_FOLDER,id);
            }

            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(CourseBasic.class)
    @PostMapping("/{id}/image")
    public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
            throws IOException {

        Course course = courseService.findById(id).orElseThrow(null);

        if (course != null) {

            URI location = fromCurrentRequest().build().toUri();

            if (!imageFile.isEmpty()) {
                course.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
                course.setImage(true);
            }
            courseService.save(course);

            imgService.saveImage(COURSES_FOLDER, course.getId(), imageFile);

            return ResponseEntity.created(location).build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

   /* @JsonView(CourseBasic.class)
    @GetMapping("/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws MalformedURLException {
        return this.imgService.createResponseFromImage(COURSES_FOLDER, id);


    }*/
    @JsonView(CourseBasic.class)
    @GetMapping("/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws MalformedURLException, SQLException {
        Optional<Course> course = courseService.findById(id);
        if (course.isPresent() && course.get().getImageFile() != null) {

            Resource file = new InputStreamResource(course.get().getImageFile().getBinaryStream());

            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                    .contentLength(course.get().getImageFile().length()).body(file);

        } else {
            return ResponseEntity.notFound().build();
        }

    }




}
