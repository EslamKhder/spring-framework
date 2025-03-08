package com.spring.restaurant.controller;

import com.spring.restaurant.service.OrderService;
import com.spring.restaurant.service.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    ResponseEntity<Map<String, String>> SaveOrder(@RequestBody OrdersDto ordersDto) {
       return ResponseEntity.created(URI.create("/orders/saveOrder")).body(orderService.saveOrder(ordersDto));
    }
}
