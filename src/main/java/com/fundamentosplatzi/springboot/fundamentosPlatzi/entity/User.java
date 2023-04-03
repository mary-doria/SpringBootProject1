package com.fundamentosplatzi.springboot.fundamentosPlatzi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //Se Creo una entidad user
@Table(name="users")
public class User {
    @Id //se agrego un ID para esa entidad
    @GeneratedValue(strategy = GenerationType.AUTO) //Cada que tengamos un registro se va a Autogenerar
    @Column(name="id_user",nullable= false , unique=true) // Esa propiedad tiene nombre de columna id_user a nivel de base de datos
    private Long id; // El ID se representa en la propiedad ID
 //Propiedades que se representan como columna
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String birthDate;


//Hicimos una relacion con otro entidad de tipo OneToMany; Un usuario va a tener muchos Posts
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();
//Constructor vacio
    public User() {
    }
//Constructor con name email y birthdate
    public User(String name, String email, String birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", posts=" + posts +
                '}';
    }
}
