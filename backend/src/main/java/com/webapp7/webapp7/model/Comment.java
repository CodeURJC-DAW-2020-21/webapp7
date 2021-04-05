package com.webapp7.webapp7.model;

import javax.persistence.*;

//DATA BASE TABLE
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String comment;


    public Comment() {}

    public Comment(String name, String comment) {
        super();
        this.name = name;
        this.comment = comment;
    }

    public Long getId() {return id; }
    public void setId(long id) {this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCommment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("Comment[id=%d, name='%s', comment='%s']",
                id, name, comment);
    }

}