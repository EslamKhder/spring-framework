package com.spring.restaurant.repository;

import com.spring.restaurant.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Optional<Orders> findByCode(String code);
    List<Orders> findByClientId(Long id);
}
