package com.fundamentosplatzi.springboot.fundamentosPlatzi.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="post")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_post",nullable= false , unique=true)
    private Long id;
    @Column(name="description",  length=255)
    private String description;
    //Relacion con Otra entidad
    @ManyToOne
    private User user;
//Constructor Vacio
    public Post() {
    }
//Constructor con description y user
    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
