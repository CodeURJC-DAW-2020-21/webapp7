package com.webapp7.webapp7.repository;

import com.webapp7.webapp7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

@Query(value = "SELECT id, email, name, password, rol, image, image_file, course_id FROM kiddyshouse.user WHERE email=:userEmail", nativeQuery = true)
User selectByEmail(@Param("userEmail")String email);

@Query(value = "SELECT id, email, name, password, rol, image, image_file, course_id FROM kiddyshouse.user WHERE rol=:userRol", nativeQuery = true)
List<User> findByRol(@Param("userRol")String rol);

@Query(value = "SELECT id, email, name, password, rol, image, image_file, course_id FROM kiddyshouse.user", nativeQuery = true)
List<User> findAllUsers();

}

