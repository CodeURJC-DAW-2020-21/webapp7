package com.webapp7.webapp7.repository;

import com.webapp7.webapp7.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Long>{

    List<Course> findByCategory(String category);
    List<Course> findByAgeStartOrAgeEnd(int ageStart, int ageEnd);
    List<Course> findByInstructor(String instructor);

}
