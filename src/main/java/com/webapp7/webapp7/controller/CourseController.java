package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.repository.CourseRepository;
import com.webapp7.webapp7.service.CourseService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {


    //PRUEBA PARA INSERTAR REGISTROS EN LA TABLA DE COURSES

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/admin/course/addCourse")
    public String addCourse(@RequestParam String category, @RequestParam String instructor, @RequestParam int ageStart, @RequestParam int ageEnd, @RequestParam int price){

        Course course= new Course();
        course.setCategory(category);
        course.setInstructor(instructor);
        course.setAgeStart(ageStart);
        course.setAgeEnd(ageEnd);
        course.setPrice(price);

        courseService.save(course);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String showCourses(Model model){
        List<Course> courses= courseRepository.findAll();
        model.addAttribute("courselist", courses);
        return "user_admin";
    }

    @GetMapping("/admin/course/{id}/delete")
    public String deleteCourse(Model model, @PathVariable long id) throws IOException {

        Course course = courseService.findById(id).orElseThrow();

        courseService.deleteById(id);


        return "redirect:/admin";
    }

    /*
    @GetMapping("/admin/course/deleteCourse")
    public String deleteCourse(@RequestParam String id){
        courseService.deleteById(id);
    }
    */
}
