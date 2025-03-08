package com.spring.restaurant.service;


import com.spring.restaurant.service.dto.OrdersDto;

import java.util.Map;

public interface OrderService {

     Map<String, String> saveOrder(OrdersDto ordersDto);
}
