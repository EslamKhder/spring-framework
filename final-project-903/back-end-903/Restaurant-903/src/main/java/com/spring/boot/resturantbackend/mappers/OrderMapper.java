package com.spring.boot.resturantbackend.mappers;

import com.spring.boot.resturantbackend.models.Order;
import com.spring.boot.resturantbackend.vm.RequestOrderVm;
import com.spring.boot.resturantbackend.vm.ResponseOrderVm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    ResponseOrderVm toResponseOrderVm(Order order);

    Order toOrder(RequestOrderVm requestOrderVm);
}
