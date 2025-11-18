package com.spring.boot.resturantbackend.services.impl;

import com.spring.boot.resturantbackend.controllers.vm.OrderVm;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductService productService;

    @Override
    public ResponseOrderVm requestOrder(RequestOrderVm requestOrderVm) {
        try {
            if (CollectionUtils.isEmpty(requestOrderVm.getProducts())) {
                throw new SystemException("products.ids.notnull");
            }

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            AccountDto accountDto = (AccountDto) authentication.getPrincipal();

            List<OrderVm> orderVms = requestOrderVm.getProducts(); // 1  5
            List<Long> productsIds = orderVms.stream().map(orderVm -> orderVm.getId()).collect(Collectors.toList());

            List<ProductDto> productDtos = productService.getProductsByIds(productsIds);

            Long totalNumber = orderVms.stream().mapToLong(orderVm -> orderVm.getQuantity()).sum();
            Double totalPrice = calculateTotalPrice(orderVms, productDtos);

            Order order = new Order();
            order.setAccount(AccountMapper.ACCOUNT_MAPPER.toAccount(accountDto));
            order.setProducts(ProductMapper.PRODUCT_MAPPER.toProduct(productDtos));
            order.setTotalNumber(totalNumber);
            order.setTotalPrice(totalPrice);

            order = orderRepo.save(order);

            String code = getCode(order.getId());

            order.setCode(code);
            orderRepo.save(order);

            return new ResponseOrderVm(code, totalPrice, totalNumber);
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private String getCode(Long id) {
        return "RES-" + id;
    }

    private Double calculateTotalPrice(List<OrderVm> orderVms, List<ProductDto> productDtos) {
        Map<Long, Double> productMap = productDtos.stream().collect(
                Collectors.toMap(ProductDto::getId, ProductDto::getPrice)
        );

        return orderVms.stream().mapToDouble(orderVm -> {
            Double price = productMap.get(orderVm.getId());
            return price * orderVm.getQuantity();
        }).sum();
    }
}
