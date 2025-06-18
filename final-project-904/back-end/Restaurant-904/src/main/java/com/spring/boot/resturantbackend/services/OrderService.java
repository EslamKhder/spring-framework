package com.spring.boot.resturantbackend.services;

import com.spring.boot.resturantbackend.vm.RequestOrderVm;
import com.spring.boot.resturantbackend.vm.ResponseOrderVm;

public interface OrderService {
    ResponseOrderVm requestOrder(RequestOrderVm requestOrderVm);
}
