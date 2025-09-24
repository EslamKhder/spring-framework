package com.spring.boot.resturantbackend.repositories;

import com.spring.boot.resturantbackend.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findByAccountId(Long accountId);
}
