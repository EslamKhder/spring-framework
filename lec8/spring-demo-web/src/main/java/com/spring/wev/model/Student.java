package com.spring.wev.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private String password;

    @JsonProperty("x")
    private int age;

    private Float GPA;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Float getGPA() {
        return GPA;
    }

    public void setGPA(Float GPA) {
        this.GPA = GPA;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
