package com.spring.boot.restaurant.dto;

import com.spring.boot.restaurant.model.enums.RoleCode;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private RoleCode code;
}
