package com.webapp7.webapp7.Service;

import com.webapp7.webapp7.model.Comment;
import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.repository.CommentRepository;
import com.webapp7.webapp7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
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
class DataBaseInitializer {

    @Autowired
    private PostRepository posts;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() throws IOException, URISyntaxException {

        // Sample books

        Comment comment1 = new Comment("Deborah", "hola que tal");

        commentRepository.save(comment1);
//
//        Book book2 = new Book("LA VIDA SECRETA DE LA MENTE",
//                "La vida secreta de la mentees un viaje especular que recorre el cerebro y el pensamiento: se trata de descubrir nuestra mente para entendernos hasta en los más pequeños rincones que componen lo que somos, cómo forjamos las ideas en los primeros días de vida, cómo damos forma a las decisiones que nos constituyen, cómo soñamos y cómo imaginamos, por qué sentimos ciertas emociones hacia los demás, cómo los demás influyen en nosotros, y cómo el cerebro se transforma y, con él, lo que somos.");
//
//        setBookImage(book2, "/sample_images/la_vida_secreta_de_la_mente.jpg");
//        bookRepository.save(book2);
//
//        bookRepository.save(new Book("CASI SIN QUERER",
//                "El amor algunas veces es tan complicado como impredecible. Pero al final lo que más valoramos son los detalles más simples, los más bonitos, los que llegan sin avisar. Y a la hora de escribir sobre sentimientos, no hay nada más limpio que hacerlo desde el corazón. Y eso hace Defreds en este libro."));
//
//        bookRepository.save(new Book("TERMINAMOS Y OTROS POEMAS SIN TERMINAR",
//                "Recopilación de nuevos poemas, textos en prosa y pensamientos del autor. Un sabio dijo una vez: «Pocas cosas hipnotizan tanto en este mundo como una llama y como la luna, será porque no podemos cogerlas o porque nos iluminan en la penumbra». Realmente no sé si alguien dijo esta cita o me la acabo de inventar pero deberían de haberla escrito porque el poder hipnótico que ejercen esa mujer de rojo y esa dama blanca sobre el ser humano es digna de estudio."));
//
//        bookRepository.save(new Book("LA LEGIÓN PERDIDA",
//                "En el año 53 a. C. el cónsul Craso cruzó el Éufrates para conquistar Oriente, pero su ejército fue destrozado en Carrhae. Una legión entera cayó prisionera de los partos. Nadie sabe a ciencia cierta qué pasó con aquella legión perdida.150 años después, Trajano está a punto de volver a cruzar el Éufrates. ..."));

         /*
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


        // Sample users

        userRepository.save(new User("user@gmail.com", "user", "1234"));
        userRepository.save(new User("admin@gmail.com", "adminpass", "5678"));
    }

    public void setPostImage(Post post, String classpathResource) throws IOException {
        post.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        post.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
    }
}
