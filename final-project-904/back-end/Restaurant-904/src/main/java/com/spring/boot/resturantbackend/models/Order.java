package com.spring.boot.resturantbackend.models;

import com.spring.boot.resturantbackend.models.security.Account;
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
    @ManyToMany
    @JoinTable(
            schema = "hr",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"order_id", "product_id"})
    )
    List<Product> products;
    @ManyToOne
    @JoinColumn(unique = true, nullable = false)
    private Account account;
}
