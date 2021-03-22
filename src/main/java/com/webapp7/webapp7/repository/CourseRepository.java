package com.webapp7.webapp7.repository;

import com.webapp7.webapp7.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

    @Query(value = "SELECT id, category, age_start, age_end, instructor, price, image_file, image  FROM kiddyshouse.course WHERE category=:courseCategory", nativeQuery = true)
    Course selectByCategory(@Param("courseCategory")String category);
}
