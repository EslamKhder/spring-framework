package com.spring.restaurant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.Order;

import java.util.List;

@Entity
@Getter
@Setter
public class Product extends BaseEntity{

    @Column(length = 500)
    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany
    private List<Orders> orders;
}
