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

    @Autowired
    private CacheManager cacheManager;

    // 1 Db   ch
    // 1 Db
    @Override
    @Cacheable(value = "products", key = "'allProducts'")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // allProducts
    @Override
    @CacheEvict(value = "products", key = "'allProducts'")
    public Product saveProduct(Product product) {
        Product productSaved = productRepo.save(product); // ex
        return productSaved;
    }

    @Override
//    @CacheEvict(value = "products", key = "'productId' + #product.id")
    @CachePut(value = "products", key = "'productId' + #product.id")
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    // 100  products       productId100   {Product-->100}
    @Override
    @CacheEvict(value = "products", key = "'productId' + #id")
    public void deleteProduct(Long id) { // 101
        productRepo.deleteById(id);
        updateCacheOnProduct(new Product(id), true);
    }

    // 100  products       productId100   {Product-->100}
    // 101  products       productById101   {Product-->100}
    @Override
    @Cacheable(value = "products", key = "'productId' + #id")
    public Product getProductBy(Long id) {//40
        return productRepo.findById(id).get();
    }


    // save
    // update
    // @CacheEvict(value = "products", key = "'allProducts'")
    private void updateCacheOnProduct(Product product, boolean remove) {
        Cache cache = cacheManager.getCache("products");
        if (cache != null) {
            List<Product> cachedProducts =
                    cache.get("allProducts", List.class);
            cachedProducts.removeIf(pro -> pro.getId().equals(product.getId()));
            if (!remove) {
                cachedProducts.add(product);
            }

            cache.put("allProducts", cachedProducts);
        }
    }


//
//    private void updateProductToCache(Product productUpdated) {
//        Cache cache = cacheManager.getCache("products");
//        if (cache != null) {
//            List<Product> cachedProducts =
//                    cache.get("allProducts", List.class);
//
//            if (cachedProducts != null) {
//                //[0,1,2,3,4,5,6]
//                int index = IntStream.range(0, cachedProducts.size())
//                        .filter(i -> cachedProducts.get(i).getId().equals(productUpdated.getId()))
//                        .findFirst()
//                        .orElse(-1);
//
//                cachedProducts.set(index, productUpdated);
//                cache.put("allProducts", cachedProducts);
//            }
//        }
//    }
}
