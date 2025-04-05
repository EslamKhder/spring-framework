package com.spring.restaurant.service.Impl;

import com.spring.restaurant.controller.vm.OrderDetailsVM;
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
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


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
        double totalPrice = products.stream().map(product -> product.getPrice()).reduce((price1, price2) -> price1 + price2).get();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        String code = UserCode.generateCode(ordersRepository.findAll().size(), client.getName());

        Orders orders = OrderMapper.ORDER_MAPPER.toEntity(ordersDto);
        orders.setClient(client);
        orders.setProducts(products);
        orders.setTotalPrice(String.valueOf(totalPrice));
        orders.setTotalQuantity(String.valueOf(products.size()));
        orders.setCode(code);

        ordersRepository.save(orders);

        Map<String, String> response = new LinkedHashMap<>();
        response.put("code", orders.getCode());
        return response;
    }

    @Override
    public OrderDetailsVM getOrderDetails(String code) throws RuntimeException {
        Optional<Orders> orders = ordersRepository.findByCode(code);

        if (orders.isEmpty()) {
            throw new RuntimeException("error.invalid.orderDetails");
        }
        Orders order = orders.get();

        return extractOrderDetailsVM(order);
    }

    @Override
    public List<OrderDetailsVM> getAllOrderDetails() {
        List<Orders> orders = ordersRepository.findAll();

        return orders.stream().map(order -> extractOrderDetailsVM(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDetailsVM> getUserOrderDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        List<Orders> orders = ordersRepository.findByClientId(client.getId());

        return orders.stream().map(order -> extractOrderDetailsVM(order)).collect(Collectors.toList());
    }

    private OrderDetailsVM extractOrderDetailsVM(Orders order) {
        OrderDetailsVM orderDetailsVM = new OrderDetailsVM();
        orderDetailsVM.setCode(order.getCode());
        orderDetailsVM.setTotalPrice(order.getTotalPrice());
        orderDetailsVM.setTotalQuantity(order.getTotalQuantity());
        orderDetailsVM.setProductDtos(ProductMapper.PRODUCT_MAPPER.toDtoList(order.getProducts()));
        return orderDetailsVM;
    }


}
