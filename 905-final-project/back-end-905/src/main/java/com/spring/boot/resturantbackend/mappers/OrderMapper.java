package com.spring.boot.resturantbackend.mappers;

import com.spring.boot.resturantbackend.dto.OrderDto;
import com.spring.boot.resturantbackend.dto.ProductDto;
import com.spring.boot.resturantbackend.models.Order;
import com.spring.boot.resturantbackend.controllers.vm.RequestOrderVm;
import com.spring.boot.resturantbackend.controllers.vm.ResponseOrderVm;
import com.spring.boot.resturantbackend.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    ResponseOrderVm toResponseOrderVm(Order order);

    Order toOrder(RequestOrderVm requestOrderVm);

    OrderDto toProductDto(Order order);
    List<OrderDto> toOrderDtoList(List<Order> order);
}
