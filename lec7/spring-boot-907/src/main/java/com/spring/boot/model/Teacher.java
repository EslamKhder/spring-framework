package com.spring.boot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//50 atr      2 atr

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public Teacher(String name, String userName, String password, String phoneNumber) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
