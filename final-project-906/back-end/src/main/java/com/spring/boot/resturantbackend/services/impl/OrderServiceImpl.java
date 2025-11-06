package com.spring.boot.resturantbackend.services.impl;

import com.spring.boot.resturantbackend.repositories.OrderRepo;
import com.spring.boot.resturantbackend.services.OrderService;
import com.spring.boot.resturantbackend.controllers.vm.RequestOrderVm;
import com.spring.boot.resturantbackend.controllers.vm.ResponseOrderVm;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public ResponseOrderVm requestOrder(RequestOrderVm requestOrderVm) {
        try {
            if (Objects.nonNull(requestOrderVm.getId())) {
                throw new SystemException("id.must_be.null");
            }
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            authentication.
            return new ResponseOrderVm();
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
