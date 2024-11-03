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

    @OneToMany(mappedBy = "teacher")
    private List<Student> students;
}
