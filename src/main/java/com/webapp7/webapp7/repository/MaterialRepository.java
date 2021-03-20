package com.webapp7.webapp7.repository;

import com.webapp7.webapp7.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Long> {
    @Query("SELECT new Material(d.id, d.name) FROM Material d ORDER BY d.id ASC")
    List<Material> findAll();
}
