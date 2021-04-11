package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/admin/courses")
public class AdminCourseControllerApi {

    @Autowired
    private com.webapp7.webapp7.Service.CourseService courseService;
    @Autowired
    private com.webapp7.webapp7.Service.UserService userService;

    @JsonView(CourseBasic.class)
    @GetMapping("/")
    public ResponseEntity<Collection<Course>> getCourse() {
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

    @PutMapping("/{id}")
    public ResponseEntity<Course> replacePost(@PathVariable long id,
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
    public ResponseEntity<Course> deleteCourse(@PathVariable long id) {
        User user = userService.findById(id).orElse(null);
        Course course = courseService.findById(id).orElse(null);
        if (course != null && user != null) {
            user.setCourse(null);
            userService.save(user);
            courseService.deleteById(id);
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    interface CourseBasic extends Course.Basic {
    }
}
