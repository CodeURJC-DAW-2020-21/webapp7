package com.webapp7.webapp7.repository;

import java.util.List;
import com.webapp7.webapp7.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    /*
    @Query("SELECT new Course (c.id, c.category) FROM Course c ORDER BY c.id ASC")
    List<Course>findAll();


     */

    /*
    List<Course> findByCategory(String category);
    List<Course> findByAgeStartOrAgeEnd(int ageStart, int ageEnd);
    List<Course> findByInstructor(String instructor);
    */
}
