package com.spring.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String salary;

    private String address;

    @Column(name = "COMMISSION_PCT")
    private float commission;
}
