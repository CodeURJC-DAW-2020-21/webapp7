package com.webapp7.webapp7.service;

//import com.webapp7.webapp7.model.Comment;
import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.model.Material;
//import com.webapp7.webapp7.repository.CommentRepository;
import com.webapp7.webapp7.repository.MaterialRepository;
import com.webapp7.webapp7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

@Service
class DataBaseInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MaterialRepository materialRepository;

 /*   @Autowired
    private CommentRepository commentRepository;
*/
    @PostConstruct
    public void init() throws IOException, URISyntaxException {

        // Sample books

//        Comment comment1 = new Comment("Deborah", "hola que tal");

//        commentRepository.save(comment1);
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


        // Sample users
       /* File file = new File("/Users/miriamdefrancisco/IdeaProjects/webapp7f/src/main/resources/static/prueba.docx");
        Material material = new Material();
        material.setName(file.getName());
        byte[] bytes = Files.readAllBytes(file.toPath());
        material.setContent(bytes);
        materialRepository.save(material);
        userRepository.save(new User("user@gmail.com", "user", "1234"));
        userRepository.save(new User("admin@gmail.com", "adminpass", "5678"));*/
    }
}
