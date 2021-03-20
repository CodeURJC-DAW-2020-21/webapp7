package com.webapp7.webapp7.Service;

import com.webapp7.webapp7.model.Comment;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Post;

import com.webapp7.webapp7.repository.CommentRepository;
import com.webapp7.webapp7.repository.CourseRepository;
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
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository posts;

    @Autowired
    private CourseRepository courseRepository;

    @PostConstruct
    public void init() throws IOException, URISyntaxException{

        /*
        //Sample courses
        Course course1= new Course("Jolly Kids 4", 5, 6, "Mercedes Huasaquiche", 120);
        setCourseImage(course1, "static/images/Niño_5a6.png");
        courseRepository.save(course1);

        Course course2= new Course("Jolly Kids 5", 7, 8, "Mercedes Huasaquiche", 130);
        setCourseImage(course1, "static/images/Niño_5a6.png");
        courseRepository.save(course2);

        Course course3= new Course("Jolly Kids 6", 9, 10, "Mercedes Huasaquiche", 140);
        setCourseImage(course1, "static/images/Niño_5a6.png");
        courseRepository.save(course3);


        */

/*


        //Sample Comments
        Comment comment1 = new Comment("Marga Jimenez Lopez", "La mejor academia de todas en las que he estado,muy buen profesorado y la directora muy maja y amable");
        commentRepository.save(comment1);

        Comment comment2 = new Comment("Alba Sevillano Portilla", "Its a good academy and learn english very good!tremendous!! I recommend it");
        commentRepository.save(comment2);

        Comment comment3 = new Comment("Pedro Alonso Fernandez", "Academia 100% recomendada. Hice algunos intensivos con ellos y aprendes mucho a la vez que te preparan para todo tipo de exámenes de una forma muy divertida.");
        commentRepository.save(comment3);

        Comment comment4 = new Comment("Miriam de Francisco Alfonso", "Nivel excelente. Profesores nativos. Trato inmejorable. Clases muy adecuadas a cada nivel, muy dinámicas y divertidas. Especial agradecimiento a mis profes");
        commentRepository.save(comment4);

        Comment comment5 = new Comment("Caridad Arias Pradas", "Muchas gracias a todo el equipo de KiddysHouse! Habéis sido súper simpaticos conmigo. Recomendaré está academia a todo el que me pregunte.");
        commentRepository.save(comment5);




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
*/

    }

    /*

    public void setPostImage(Post post, String classpathResource) throws IOException {
        post.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        post.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
    }

    public void setCourseImage(Course course, String classpathResource) throws IOException {
        course.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        course.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
    }

    */

}
