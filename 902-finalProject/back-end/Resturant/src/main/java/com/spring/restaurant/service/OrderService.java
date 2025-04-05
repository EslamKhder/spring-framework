package com.spring.restaurant.service;


import com.spring.restaurant.controller.vm.OrderDetailsVM;
import com.spring.restaurant.service.dto.OrdersDto;
import jakarta.transaction.SystemException;

import java.util.List;
import java.util.Map;

public interface OrderService {

     Map<String, String> saveOrder(OrdersDto ordersDto);
     OrderDetailsVM getOrderDetails(String code) throws RuntimeException;
     List<OrderDetailsVM> getAllOrderDetails();
     List<OrderDetailsVM> getUserOrderDetails();
}
