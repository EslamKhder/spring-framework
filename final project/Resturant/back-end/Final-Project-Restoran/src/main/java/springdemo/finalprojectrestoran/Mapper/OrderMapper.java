package springdemo.finalprojectrestoran.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springdemo.finalprojectrestoran.dto.OrdersDto;
import springdemo.finalprojectrestoran.model.Orders;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    Orders toEntity(OrdersDto ordersDto);
    List<Orders> toEntity(List<OrdersDto> ordersDto);

    OrdersDto toDto(Orders orders);
    List<OrdersDto> toDto(List<Orders> orders);
}
