package com.webapp7.webapp7.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    @Lob
    private Blob imageFile;
    private boolean image;

    public Post() {}

    public Post(String title, String description) {
        super();
        this.title = title;
        this.description = description;

    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getImageFile() {
        return imageFile;
    }

    public void setImageFile(Blob image) {
        this.imageFile = image;
    }

    public boolean hasImage(){
        return this.image;
    }

    public void setImage(boolean image){
        this.image = image;
    }

    @Override
    public String toString() {
        return String.format("Comment[id=%d, title='%s', description='%s']",
                id, title, description);
    }


}




