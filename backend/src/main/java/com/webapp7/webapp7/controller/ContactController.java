package com.webapp7.webapp7.controller;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.UnsupportedEncodingException;


@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contactUs")
    public String submitContact(HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject ");
        String content = request.getParameter("content");

        MimeMessage message =  mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String mailSubject = name + "has sent a message";
        String mailContent= "<p><b>Sender name:</b>" + name+ "</p>";
        mailContent += "<p><b>Sender E-mail:</b> " + email + "</p>";
        mailContent += "<p><b>Subject:</b> " + subject + "</p>";
        mailContent += "<p><b>Content:</b> " + content + "</p>";

        helper.setFrom("jesuxever@hotmail.es", "Contacto usuario no registrado");
        helper.setTo("deborahisraelvillanueva@gmail.com");
        helper.setSubject(mailSubject);
        helper.setText(mailContent,true);

        mailSender.send(message);

        return "message";
    }
}
