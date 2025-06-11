package com.spring.boot.resturantbackend.services;

import com.spring.boot.resturantbackend.vm.RequestOrderVm;
import com.spring.boot.resturantbackend.vm.ResponseOrderVm;
import jakarta.transaction.SystemException;

public interface OrderService {
    ResponseOrderVm requestOrder(RequestOrderVm requestOrderVm) throws SystemException;
}
