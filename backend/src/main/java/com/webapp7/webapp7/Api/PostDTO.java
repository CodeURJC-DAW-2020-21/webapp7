package com.webapp7.webapp7.Api;


public class PostDTO {
    private long id;
    private String title;
    private String description;

    public long getId() {
        return id;
    }

    public PostDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PostDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}