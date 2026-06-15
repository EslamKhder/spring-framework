package com.spring.boot.resturantbackend.services;

import com.spring.boot.resturantbackend.controllers.vm.RequestOrderVm;
import com.spring.boot.resturantbackend.controllers.vm.ResponseOrderVm;

public interface OrderService {
    ResponseOrderVm requestOrder(RequestOrderVm requestOrderVm);
}
