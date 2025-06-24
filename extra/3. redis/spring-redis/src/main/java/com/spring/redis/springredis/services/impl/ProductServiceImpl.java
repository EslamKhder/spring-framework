package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.Product;
import com.spring.redis.springredis.repositories.ProductRepo;
import com.spring.redis.springredis.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    @Cacheable(value = "products", key = "'all'")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    @CacheEvict(value = "products", key = "'all'")
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    @CacheEvict(value = "products", key = "'all'")
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    @CacheEvict(value = "products", key = "'all'")
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    // TODO TASK create function to get product by id apply Cache

}
