package com.webapp7.webapp7.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Para generar el esquema y para hacer la conversión entre objetos y filas */
@Entity
public class User {
    /* la claveprimaria de la tabla.*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String username;
    private String password;
    private String rol;
    public User(User user){}




    public User(String email, String username, String password, String rol) {
        super();
        this.email = email;
        this.username = username;
        this.password = password;
        this.rol= rol;
    }

    public User() {

    }


    public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public void deleteById(long id){

    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    @Override
	public String toString() {
		return String.format("User[id=%d, email='%s', username='%s', password='%s', rol='%s']",
				id, email, username,password, rol);
	}



}
