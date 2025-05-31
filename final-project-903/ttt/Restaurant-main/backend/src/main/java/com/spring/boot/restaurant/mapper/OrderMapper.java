package com.spring.boot.restaurant.mapper;

import com.spring.boot.restaurant.dto.OrderDto;
import com.spring.boot.restaurant.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface OrderMapper {

    @Mapping(source = "user.id", target = "userId")
    OrderDto toDto(Order order);

    @Mapping(source = "userId", target = "user.id")
    Order toEntity(OrderDto dto);

    List<OrderDto> toDtoList(List<Order> orders);

    List<Order> toEntityList(List<OrderDto> dtos);
}

