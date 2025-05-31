package com.spring.boot.resturantbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(schema = "hr", name = "Order_Entity")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private double totalPrice;
    @Column(nullable = false)
    private double totalNumber;
    @ManyToMany(mappedBy = "orders")
    List<Product> products;
    @ManyToOne
    @JoinColumn(unique = true, nullable = false)
    private UserEntity user;
}
