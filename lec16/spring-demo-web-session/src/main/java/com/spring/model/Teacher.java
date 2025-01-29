package com.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Teacher extends BaseEntity{

    private double salary;

    private String password;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Student> students;
}
