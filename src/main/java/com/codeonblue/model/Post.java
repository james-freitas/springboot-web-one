package com.codeonblue.model;

public class Post {

    private Long id;
    private String description;

    public Post(String description) {
        this.description = description;
    }

    public Post() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
