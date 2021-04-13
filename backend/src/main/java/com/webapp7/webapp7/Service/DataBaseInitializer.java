package com.webapp7.webapp7.Service;

import antlr.BaseAST;
import com.webapp7.webapp7.model.Comment;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.repository.CommentRepository;
import com.webapp7.webapp7.repository.CourseRepository;
import com.webapp7.webapp7.repository.PostRepository;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.repository.UserRepository;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
public class DataBaseInitializer {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() throws IOException, URISyntaxException{


        //Sample Comments
        Comment comment1 = new Comment("Deborah Israel Villanueva", "La mejor academia de todas en las que he estado,muy buen profesorado y la directora muy maja y amable");
        commentRepository.save(comment1);

        Comment comment2 = new Comment("Alba Sevillano Portilla", "Its a good academy and learn english very good!tremendous!! I recommend it");
        commentRepository.save(comment2);

        Comment comment3 = new Comment("Jesús Sebastián Tocas", "Academia 100% recomendada. Hice algunos intensivos con ellos y aprendes mucho a la vez que te preparan para todo tipo de exámenes de una forma muy divertida.");
        commentRepository.save(comment3);

        Comment comment4 = new Comment("Miriam de Francisco", "Nivel excelente. Profesores nativos. Trato inmejorable. Clases muy adecuadas a cada nivel, muy dinámicas y divertidas. Especial agradecimiento a mis profes");
        commentRepository.save(comment4);

        Comment comment5 = new Comment("Caridad Arias Pradas", "Muchas gracias a todo el equipo de KiddysHouse! Habéis sido súper simpaticos conmigo. Recomendaré está academia a todo el que me pregunte.");
        commentRepository.save(comment5);


        //Sample Posts
        Post post1 = new Post(
                "Matrículas abiertas para el nuevo curso",
                "Desde el lunes 22 de febrero, usted ya puede solicitar la matrícula de nuestros cursos de inglés para sus hijos. Les recordamos que ustedes pueden ver nuestra oferta educativa dentro de la sección de \"Cursos\", para que puedan averiguar un poco más de información al respecto");
        setPostImage(post1, "static/images/MatriculasAbiertas.png");
        postRepository.save(post1);

        Post post2 = new Post(
                "Información sobre los nuevos cursos",
                "A partir de ahora, los padres de familia podrán tener a disposición la información necesaria sobre los cursos que tendremos a disposición, el rango de edades en los que está centrado esta institución, los horarios, etc.Toda esta información y más podrá encontrarla dentro de la sección de \"Cursos\", donde podrá consultar todos datos que usted necesita para los cursos que vayan a cursar sus hijos");
        setPostImage(post2, "static/images/MasInfoKiddysHouse.png");
        postRepository.save(post2);

        Post post3 = new Post(
                "¡Apertura de Kiddy's House!",
                "Les anunciamos a todos que próximamente se llevará a cabo la apertura de nuestra escuela de inglés \"Kiddy's House\", enfocada para los niños más pequeños de la casa para que, desde una edad temprana, puedan introducirse a un nuevo idioma de una forma muy divertida y entretenida desde la comodidad de sus casas. En breve les anunciaremos toda la información necesaria a los padres de familia para que ");
                //puedan enterarse de toda nuestra oferta educativa y nuestra dinámica de trabajo. Esto es todo los que les podemos decir por el momento, pero empezamos este proyecto con mucha ilusión y con ganas que sus pequeños puedan aprender todo lo necesario del inglés para que tengan una buena base en el futuro.
        setPostImage(post3, "static/images/AperturaKiddysHouseBlog.png");
        postRepository.save(post3);

        //Sample users

        User user1= new User("alumno@gmail.com", "alumno", passwordEncoder.encode("pass"), "alumno");
        setUserImage(user1, "static/images/teacher-2.jpg");
        userRepository.save(user1);

        User user2= new User("admin@gmail.com", "admin", passwordEncoder.encode("pass"), "administrador");
        setUserImage(user2, "static/images/teacher-2.jpg");
        userRepository.save(user2);

        User user4= new User("profesor@gmail.com", "profesor", passwordEncoder.encode("pass"), "profesor");
        setUserImage(user4, "static/images/teacher-2.jpg");
        userRepository.save(user4);

        User user5= new User("alumno2@gmail.com", "al2", passwordEncoder.encode("pass"), "alumno");
        setUserImage(user5, "static/images/teacher-2.jpg");
        userRepository.save(user5);

        User user6= new User("alumno3@gmail.com", "al3", passwordEncoder.encode("pass"), "alumno");
        setUserImage(user6, "static/images/teacher-2.jpg");
        userRepository.save(user6);

        //Sample Courses
        ArrayList<User> list1 = new ArrayList<User>();
        list1.add(user1);
        list1.add(user5);
        list1.add(user6);

        Course course1= new Course("Jolly Kids", 5, 6,"profesor@gmail.com",  120,list1);
        setCourseImage(course1, "static/images/Niño_5a6.png");
        courseRepository.save(course1);

        ArrayList<User> list2 = new ArrayList<User>();

        Course course2= new Course("Explorer Kids", 7, 8,"profesor@gmail.com",  130,list2);
        setCourseImage(course2, "static/images/Niño_7a8.png");
        courseRepository.save(course2);

        ArrayList<User> list3 = new ArrayList<User>();

        Course course3= new Course("Keen Kids", 9, 10, "profesor@gmail.com", 140,list3);
        setCourseImage(course3, "static/images/Niño_9a10.png");
        courseRepository.save(course3);




    }

    public void setUserImage(User user, String classpathResource) throws IOException {
        user.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        user.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
    }

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

}
