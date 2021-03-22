package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Material;
import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.repository.CourseRepository;
import com.webapp7.webapp7.repository.MaterialRepository;
import com.webapp7.webapp7.repository.UserRepository;
import com.webapp7.webapp7.service.CourseService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;


    @PostMapping("/admin/course/addCourse")
    public String addCourse(@RequestParam String category, @RequestParam String instructor, @RequestParam int ageStart, @RequestParam int ageEnd, @RequestParam int price, MultipartFile imageField) throws IOException {
        Course course= new Course();
        course.setCategory(category);
        course.setInstructor(instructor);
        course.setAgeStart(ageStart);
        course.setAgeEnd(ageEnd);
        course.setPrice(price);

        if (!imageField.isEmpty()) {
            course.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
            course.setImage(true);
        }

        courseService.save(course);
        return "redirect:/admin";
    }


    @GetMapping("/course")
    public String course(Model model){
        List<Course> courses = courseService.listCourse();
        model.addAttribute("courses",courses);
        return "course";
    }



    @GetMapping("/admin/course/delete")
    public String deleteCourse(@RequestParam("category_delete") String category) throws IOException {
        Course course = courseService.findByCategory(category);
        Long id = course.getId();
        courseService.deleteById(id);

        return "redirect:/admin";
    }

    @GetMapping("/course/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {

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
