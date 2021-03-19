package com.webapp7.webapp7.service;

import com.webapp7.webapp7.model.Post;

import com.webapp7.webapp7.repository.PostRepository;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class DataBaseInitializer {

    @Autowired
    private PostRepository posts;

    @PostConstruct
    public void init() throws IOException, URISyntaxException{

        //Sample Posts
        Post post1 = new Post(
                "Matrículas abiertas para el nuevo curso",
                "Desde el lunes 22 de febrero, usted ya puede solicitar la matrícula de nuestros cursos de inglés para sus hijos. Les recordamos que ustedes pueden ver nuestra oferta educativa dentro de la sección de \"Cursos\", para que puedan averiguar un poco más de información al respecto");
        setPostImage(post1, "static/images/MatriculasAbiertas.png");
        posts.save(post1);

        Post post2 = new Post(
                "Información sobre los nuevos cursos",
                "A partir de ahora, los padres de familia podrán tener a disposición la información necesaria sobre los cursos que tendremos a disposición, el rango de edades en los que está centrado esta institución, los horarios, etc.Toda esta información y más podrá encontrarla dentro de la sección de \"Cursos\", donde podrá consultar todos datos que usted necesita para los cursos que vayan a cursar sus hijos");
        setPostImage(post2, "static/images/MasInfoKiddysHouse.png");
        posts.save(post2);

        Post post3 = new Post(
                "¡Apertura de Kiddy's House!",
                "Les anunciamos a todos que próximamente se llevará a cabo la apertura de nuestra escuela de inglés \"Kiddy's House\", enfocada para los niños más pequeños de la casa para que, desde una edad temprana, puedan introducirse a un nuevo idioma de una forma muy divertida y entretenida desde la comodidad de sus casas. En breve les anunciaremos toda la información necesaria a los padres de familia para que ");
                //puedan enterarse de toda nuestra oferta educativa y nuestra dinámica de trabajo. Esto es todo los que les podemos decir por el momento, pero empezamos este proyecto con mucha ilusión y con ganas que sus pequeños puedan aprender todo lo necesario del inglés para que tengan una buena base en el futuro.
        setPostImage(post3, "static/images/AperturaKiddysHouseBlog.png");
        posts.save(post3);


    }

    public void setPostImage(Post post, String classpathResource) throws IOException {
        post.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        post.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
    }

}
