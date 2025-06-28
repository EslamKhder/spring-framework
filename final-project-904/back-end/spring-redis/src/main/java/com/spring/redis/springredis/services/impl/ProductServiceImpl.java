package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.enums.KeyRegion;
import com.spring.redis.springredis.enums.Region;
import com.spring.redis.springredis.models.Product;
import com.spring.redis.springredis.repositories.ProductRepo;
import com.spring.redis.springredis.services.CashService;
import com.spring.redis.springredis.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
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

    @Autowired
    private CashService cashService;

    @Override
    @Cacheable(value = "products", key = "'all'")  // 10
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    @CacheEvict(value = "products", key = "'all'")
    @CachePut(value = "products", key = "#result.id") //
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
//    @CacheEvict(value = "products", key = "#result.id")
    @CachePut(value = "products", key = "#result.id")
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "products", key = "#id")
//            @CacheEvict(value = "products", key = "'all'")
    })
    public void deleteProduct(Long id) { // 1   9
        productRepo.deleteById(id);

        // Remove from cached "all" list manually
        cashService.removeKeyFromCashById(id, Region.products, KeyRegion.all.name());
    }


    // 55 -> products  customProduct  55{........}
    // 66
    @Override
    @Cacheable(value = "products", key = "#id")
    public Product getProductBy(Long id) {
        return productRepo.findById(id).get();
    }
}
