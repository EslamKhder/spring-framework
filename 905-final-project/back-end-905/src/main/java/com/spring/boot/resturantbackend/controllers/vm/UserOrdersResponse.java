package com.spring.boot.resturantbackend.controllers.vm;

import com.spring.boot.resturantbackend.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserOrdersResponse {

    private List<OrderDto> orderDtos;

    private Integer size;

    private Double price;


}
