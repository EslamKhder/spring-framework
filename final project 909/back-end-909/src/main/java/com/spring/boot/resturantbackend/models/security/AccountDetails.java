package com.spring.boot.resturantbackend.models.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "hr")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String address;
    @OneToOne
    private Account account;
}
