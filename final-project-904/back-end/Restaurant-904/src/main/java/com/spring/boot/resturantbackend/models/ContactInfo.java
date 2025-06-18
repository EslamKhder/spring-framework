package com.spring.boot.resturantbackend.models;

import com.spring.boot.resturantbackend.models.security.Account;
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
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String message;
    @ManyToOne
    private Account account;
}
