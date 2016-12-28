package com.codeonblue.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Column(columnDefinition = "TEXT")
    private String teaser;

    private String slug;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime postedOn;

    @ManyToOne
    private Author author;

    // need by JPA
    private Post(){

    }

    public Post(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(LocalDateTime postedOn) {
        this.postedOn = postedOn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", teaser='" + teaser + '\'' +
                ", slug='" + slug + '\'' +
                ", postedOn=" + postedOn +
                ", author=" + author +
                '}';
    }
}
