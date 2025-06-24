package com.spring.redis.springredis.services;

import com.spring.redis.springredis.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);

    // TODO TASK create function to get product by id
}
