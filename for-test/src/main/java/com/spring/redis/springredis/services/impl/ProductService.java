package com.spring.redis.springredis.services.impl;


import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public String getProductById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid product ID");
        }
        return "Product#" + id;
    }

    public void slowService() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Finished slowService logic.");
    }
}