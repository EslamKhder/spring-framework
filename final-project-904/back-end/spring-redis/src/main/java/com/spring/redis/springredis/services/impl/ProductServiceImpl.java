package com.spring.redis.springredis.services.impl;


import com.spring.redis.springredis.models.Product;
import com.spring.redis.springredis.repositories.ProductRepo;
import com.spring.redis.springredis.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

//    @Autowired
//    private CacheManager cacheManager;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        Product productSaved = productRepo.save(product); // ex
        return productSaved;
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getProductBy(Long id) {//40
        return productRepo.findById(id).get();
    }

}
