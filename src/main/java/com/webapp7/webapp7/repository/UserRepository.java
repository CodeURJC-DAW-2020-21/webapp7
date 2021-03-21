package com.webapp7.webapp7.repository;

import com.webapp7.webapp7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import java.util.List;

/**El interfaz padre JpaRepository dispone de métodos para consultar, guardar, borrar y modificar objetos de la base de datos */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
/**Consultas a la BBDD en base al email */

@Query(value = "SELECT id, email, username, password, rol, image, image_file  FROM kiddyshouse.user WHERE email=:userEmail", nativeQuery = true)
User selectByEmail(@Param("userEmail")String email);

@Query(value = "SELECT id, email, username, password, rol, image, image_file  FROM kiddyshouse.user WHERE rol=:userRol", nativeQuery = true)
List<User> findByRol(@Param("userRol")String rol);

}

