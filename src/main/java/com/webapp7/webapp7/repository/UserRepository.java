package com.webapp7.webapp7.repository;

import com.webapp7.webapp7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import java.util.List;

/**El interfaz padre JpaRepository dispone de métodos para consultar, guardar, borrar y modificar objetos de la base de datos */
public interface UserRepository extends JpaRepository<User,Long> {
/**Consultas a la BBDD en base al email */

    Optional<User>  findByUsername(String username);

}

