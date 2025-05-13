package com.spring.boot.spring903.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(name = "phone")
    private String phoneNumber;

    @ManyToMany(mappedBy = "accounts", fetch = FetchType.EAGER)
    private List<Role> roles;

}
