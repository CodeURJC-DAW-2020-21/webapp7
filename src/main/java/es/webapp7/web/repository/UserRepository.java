package es.webapp7.web.repository;

import es.webapp7.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**El interfaz padre JpaRepository dispone de métodos para consultar, guardar, borrar y modificar objetos de la base de datos */
public interface UserRepository extends JpaRepository<User,Long> {
/**Consultas a la BBDD en base al email */
    List<User> findByEmail(String email);
}

