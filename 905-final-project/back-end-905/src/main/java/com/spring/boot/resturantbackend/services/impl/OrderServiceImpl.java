package com.spring.boot.resturantbackend.services.impl;

import com.spring.boot.resturantbackend.dto.ProductDto;
import com.spring.boot.resturantbackend.dto.security.AccountDto;
import com.spring.boot.resturantbackend.mappers.ProductMapper;
import com.spring.boot.resturantbackend.mappers.security.AccountMapper;
import com.spring.boot.resturantbackend.models.Order;
import com.spring.boot.resturantbackend.repositories.OrderRepo;
import com.spring.boot.resturantbackend.services.OrderService;
import com.spring.boot.resturantbackend.controllers.vm.RequestOrderVm;
import com.spring.boot.resturantbackend.controllers.vm.ResponseOrderVm;
import com.spring.boot.resturantbackend.services.ProductService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductService productService;

    @Override
    public ResponseOrderVm requestOrder(RequestOrderVm requestOrderVm) {

        List<ProductDto> productDtoList = productService.getProductByIds(requestOrderVm.getProductsIds());

        AccountDto accountDto = (AccountDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Order order = new Order();
        order.setTotalPrice(requestOrderVm.getTotalPrice());
        order.setTotalNumber(requestOrderVm.getTotalNumber());
        order.setProducts(ProductMapper.PRODUCT_MAPPER.toProductList(productDtoList));
        order.setAccount(AccountMapper.ACCOUNT_MAPPER.toAccount(accountDto));

        Order orderSaved = orderRepo.save(order);

        Long id = orderSaved.getId();
        String code = "RES-" + id;
        orderSaved.setCode(code);

        orderSaved = orderRepo.save(order);

        return new ResponseOrderVm(orderSaved.getCode(), orderSaved.getTotalPrice(), orderSaved.getTotalNumber());
    }
}
