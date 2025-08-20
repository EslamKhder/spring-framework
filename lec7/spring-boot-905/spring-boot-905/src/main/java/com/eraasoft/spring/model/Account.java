package com.eraasoft.spring.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;

    private String phone;

    private String address;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Role> roles;

}
