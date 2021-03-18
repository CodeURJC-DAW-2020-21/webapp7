package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {


    //PRUEBA PARA INSERTAR REGISTROS EN LA TABLA DE COURSES

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @PostMapping("/admin/course/addCourse")
    public String addUsers(@RequestParam String category, @RequestParam String instructor, @RequestParam int ageStart, @RequestParam int ageEnd, @RequestParam int price){

        Course course= new Course();
        course.setCategory(category);
        course.setInstructor(instructor);
        course.setAgeStart(ageStart);
        course.setAgeEnd(ageEnd);
        course.setPrice(price);

        courseService.save(course);
        return "redirect:/admin";
    }

}
