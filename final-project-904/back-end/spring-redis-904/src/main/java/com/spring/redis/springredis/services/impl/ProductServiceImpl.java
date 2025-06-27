package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.Product;
import com.spring.redis.springredis.repositories.ProductRepo;
import com.spring.redis.springredis.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Cacheable(value = "products", key = "'allProducts'")
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // 150
    @Override
    @CacheEvict(value = "products", key = "'allProducts'")
    @CachePut(value = "products", key = "#product.id")
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    @CacheEvict(value = "products", key = "'allProducts'")
    @CachePut(value = "products", key = "#product.id")
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "products", key = "'allProducts'"),
            @CacheEvict(value = "products", key = "#id")
    })
    public void deleteProduct(Long id) { // 10
        productRepo.deleteById(id);
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public Product getProductBy(Long id) {
        return productRepo.findById(id).get();
    }

    // 1005
    // category        1005
    // update 1005

}
