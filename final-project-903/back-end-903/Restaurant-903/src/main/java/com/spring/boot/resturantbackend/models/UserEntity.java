package com.spring.boot.resturantbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(schema = "hr")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @OneToOne(mappedBy = "userEntity")
    private UserDetails userDetails;
    @ManyToMany(mappedBy = "users")
    private List<RoleEntity> roles;
    @OneToMany(mappedBy = "user")
    private List<ContactInfo> contacts;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
