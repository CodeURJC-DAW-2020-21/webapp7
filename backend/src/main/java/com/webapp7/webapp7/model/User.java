package com.webapp7.webapp7.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.sql.Delete;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

//DATA BASE TABLE
@Entity
public class User {

    public interface Basic {}

    public interface NumberMaterial{}


    @JsonView(User.Basic.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(User.Basic.class)
    private String email;

    @JsonView({User.Basic.class,NumberMaterial.class})
    @Column(length = 135, nullable = false, unique = true)
    private String name;

    @JsonView(User.Basic.class)
    private String password;

    @JsonView(User.Basic.class)
    private String rol;

    @Lob
    @JsonIgnore
    private Blob imageFile;
    @JsonIgnore
    private boolean image;


    @ManyToMany
    @JsonIgnore
    private List<Material> finishedMaterials;

    @JsonView({User.Basic.class,NumberMaterial.class})
    private int numberMaterial;


    @OneToOne
    @JsonView(User.Basic.class)
    private Course course;

    public List<Material> getFinishedMaterials() {
        return finishedMaterials;
    }

    public void setFinishedMaterials(List<Material> finishedMaterials) {
        this.finishedMaterials = finishedMaterials;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setNumberMaterial(int numberMaterial) {
        this.numberMaterial = numberMaterial;
    }

    public int getNumberMaterial() {
        return numberMaterial;
    }


    public User(User user) {
    }

    public User(String email, String name, String password, String rol) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.rol = rol;
        this.course = null;
        this.finishedMaterials = null;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void deleteById(long id) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public Blob getImageFile() {
        return imageFile;
    }

    public void setImageFile(Blob image) {
        this.imageFile = image;
    }

    public boolean hasImage() {
        return this.image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, email='%s', username='%s', password='%s', rol='%s']",
                id, email, name, password, rol);
    }

}

