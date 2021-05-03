package com.webapp7.webapp7.Api;


import com.webapp7.webapp7.model.Comment;
import com.webapp7.webapp7.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/email")
public class EmailApi {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/")
    public ResponseEntity<String> submitContact(HttpServletRequest request, @RequestBody Email e) throws MessagingException, UnsupportedEncodingException {
        String name = e.getNombre();
        String email = e.getEmail();
        String subject = e.getAsunto();
        String content = e.getContenido();

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String mailSubject = name + "has sent a message";
        String mailContent = "<p><b>Sender name:</b>" + name + "</p>";
        mailContent += "<p><b>Sender E-mail:</b> " + email + "</p>";
        mailContent += "<p><b>Subject:</b> " + subject + "</p>";
        mailContent += "<p><b>Content:</b> " + content + "</p>";

        helper.setFrom("jesuxever@hotmail.es", "Contacto usuario no registrado");
        helper.setTo("deborahisraelvillanueva@gmail.com");
        helper.setSubject(mailSubject);
        helper.setText(mailContent, true);

        mailSender.send(message);

        return ResponseEntity.ok("message");


    }
}
