package com.spring.boot.resturantbackend.models;

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
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String spec;
    @Column(nullable = false)
    private String logoPath;
    @Column(nullable = false)
    private String faceLink;
    @Column(nullable = false)
    private String tweLink;
    @Column(nullable = false)
    private String instaLink;
}
