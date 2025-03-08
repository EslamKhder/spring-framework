package com.spring.restaurant.service.Impl;

import com.spring.restaurant.mapper.OrderMapper;
import com.spring.restaurant.mapper.ProductMapper;
import com.spring.restaurant.model.Orders;
import com.spring.restaurant.model.Product;
import com.spring.restaurant.model.clientmodels.Client;
import com.spring.restaurant.repository.OrdersRepository;
import com.spring.restaurant.service.Jwt.ClientService;
import com.spring.restaurant.service.OrderService;
import com.spring.restaurant.service.ProductService;
import com.spring.restaurant.service.dto.OrdersDto;
import com.spring.restaurant.util.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

//    @Override
//    public void saveOrder(OrdersDto ordersDto) {
//
//        Orders order = OrderMapper.ORDER_MAPPER.toEntity(ordersDto);
//
//        ordersRepository.save(order);
//
//    }

    @Override
    public Map<String, String> saveOrder(OrdersDto ordersDto) {

        List<Product> products = ProductMapper.PRODUCT_MAPPER.toEntityList(productService.findProductsByIds(ordersDto.getProductsIds()));
        // TO DO  get client from auth context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        Orders orders = OrderMapper.ORDER_MAPPER.toEntity(ordersDto);
        orders.setClient(client);
        orders.setProducts(products);

        orders.setCode(UserCode.extractCode());
        ordersRepository.save(orders);

        Map<String, String> response = new LinkedHashMap<>();
        response.put("code", orders.getCode());
        return response;
    }


}
