package com.webapp7.webapp7.model;


import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Email {
    String nombre;
    String email;
    String asunto;
    String contenido;

    public Email(String nombre, String email, String asunto, String contenido) {
        this.nombre = nombre;
        this.email = email;
        this.asunto = asunto;
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public Email setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Email setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAsunto() {
        return asunto;
    }

    public Email setAsunto(String asunto) {
        this.asunto = asunto;
        return this;
    }

    public String getContenido() {
        return contenido;
    }

    public Email setContenido(String contenido) {
        this.contenido = contenido;
        return this;
    }
}
