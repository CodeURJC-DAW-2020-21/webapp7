package com.webapp7.webapp7.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.PostRemove;

import com.webapp7.webapp7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.repository.CourseRepository;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courses;


    @PostRemove
    public void finish(){
        courses.deleteAll();
    }

    public List<Course> listCourse (){
        return courses.findAll();
    }


    public Optional<Course> findById(long id){
        return courses.findById(id);
    }

    public void save(Course course){
        courses.save(course);
    }

    public void deleteById(long id){
        courses.deleteById(id);
    }

    public Course findByCategory(String category) {
        Course c = courses.selectByCategory(category);
        return c;
    }


    //public List<Course> show


}
