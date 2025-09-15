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

    @Override
    @Cacheable(value = "products", key = "'allProducts'")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    @CacheEvict(value = "products", key = "'allProducts'")
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    @CachePut(value = "products", key = "#product.id")
    @CacheEvict(value = "products", key = "'allProducts'")
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    // allProducts    #id

    @Caching(
            evict = {
                    @CacheEvict(value = "products", key = "'allProducts'"),
                    @CacheEvict(value = "products", key = "#id")
            }
    )
    public void deleteProduct(Long id) { // 101
        productRepo.deleteById(id);
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public Product getProductBy(Long id) {//40
        return productRepo.findById(id).get();
    }
}
