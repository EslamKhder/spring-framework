package springdemo.finalprojectrestoran.Service;


import springdemo.finalprojectrestoran.dto.OrdersDto;
import springdemo.finalprojectrestoran.model.Orders;

import java.util.List;
import java.util.Map;

public interface OrderService {

     Map<String, String> saveOrder(OrdersDto ordersDto);
}
