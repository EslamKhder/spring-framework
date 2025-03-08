package com.spring.restaurant.service.dto.Jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.restaurant.service.dto.OrdersDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

   private List<OrdersDto> requestOrders;
   private List<RoleDto> roles;
}
