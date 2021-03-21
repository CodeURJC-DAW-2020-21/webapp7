package com.webapp7.webapp7.repository;

import java.util.List;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

    @Query(value = "SELECT id, category, age_start, age_end, instructor, price, image_file, image  FROM kiddyshouse.course WHERE category=:courseCategory", nativeQuery = true)
    Course selectByCategory(@Param("courseCategory")String category);

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
