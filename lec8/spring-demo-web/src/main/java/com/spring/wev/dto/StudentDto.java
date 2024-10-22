package com.spring.wev.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class StudentDto {

    private Long id;

    private String name;

    @JsonIgnore
    private String password;

    private int age;

    private Float GPA;

    private double avgOfAge;

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


    public double getAvgOfAge() {
        return avgOfAge;
    }

    public void setAvgOfAge(double avgOfAge) {
        this.avgOfAge = avgOfAge;
    }
}
