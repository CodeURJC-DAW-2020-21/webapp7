package com.webapp7.webapp7.repository;

import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Long> {
    @Query(value = "SELECT id, name, course_id, content FROM kiddyshouse.material ORDER BY id ASC", nativeQuery = true)
    List<Material> findAll();

}
