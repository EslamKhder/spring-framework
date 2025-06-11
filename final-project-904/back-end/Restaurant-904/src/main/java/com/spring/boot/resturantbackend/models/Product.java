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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String imagePath;
    @Column(nullable = false, length = 1000)
    private String description;
    @Column(nullable = false)
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @ManyToMany
    @JoinTable(
            schema = "hr",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"order_id", "product_id"})
    )
    private List<Order> orders;
}
