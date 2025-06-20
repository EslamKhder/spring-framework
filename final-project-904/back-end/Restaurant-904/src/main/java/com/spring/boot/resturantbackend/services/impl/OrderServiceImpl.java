package com.spring.boot.resturantbackend.services.impl;

import com.spring.boot.resturantbackend.dto.ProductDto;
import com.spring.boot.resturantbackend.dto.security.AccountDto;
import com.spring.boot.resturantbackend.mappers.ProductMapper;
import com.spring.boot.resturantbackend.mappers.security.AccountMapper;
import com.spring.boot.resturantbackend.models.Order;
import com.spring.boot.resturantbackend.repositories.OrderRepo;
import com.spring.boot.resturantbackend.services.OrderService;
import com.spring.boot.resturantbackend.services.ProductService;
import com.spring.boot.resturantbackend.vm.RequestOrderVm;
import com.spring.boot.resturantbackend.vm.ResponseOrderVm;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    public static final String CODE = "CODE-";
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductService productService;

    @Override
    public ResponseOrderVm requestOrder(RequestOrderVm requestOrderVm) {
        try {
            if (Objects.nonNull(requestOrderVm.getId())) {
                throw new SystemException("id.must_be.null");
            }
            List<ProductDto> productDtos = productService.getProductByIds(requestOrderVm.getProductsIds());

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            AccountDto accountDto = (AccountDto) authentication.getPrincipal();

            Order order = new Order();
            order.setTotalNumber(requestOrderVm.getTotalNumber());
            order.setTotalPrice(requestOrderVm.getTotalPrice());
            order.setCode(CODE);
            order.setAccount(AccountMapper.ACCOUNT_MAPPER.toAccount(accountDto));
            order.setProducts(ProductMapper.PRODUCT_MAPPER.toProductList(productDtos));
            Order orderSaved = orderRepo.save(order);

            orderSaved.setCode(CODE + orderSaved.getId());
            orderRepo.save(order);
            return new ResponseOrderVm(orderSaved.getId(), accountDto.getId(), orderSaved.getCode(), requestOrderVm.getTotalPrice(), requestOrderVm.getTotalNumber());
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
