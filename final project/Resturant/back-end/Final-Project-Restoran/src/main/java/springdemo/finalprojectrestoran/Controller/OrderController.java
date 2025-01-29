package springdemo.finalprojectrestoran.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springdemo.finalprojectrestoran.Service.OrderService;
import springdemo.finalprojectrestoran.dto.OrdersDto;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    ResponseEntity<Map<String, String>> SaveOrder(@RequestBody OrdersDto ordersDto) {
       return ResponseEntity.created(URI.create("/orders/saveOrder")).body(orderService.saveOrder(ordersDto));
    }
}
