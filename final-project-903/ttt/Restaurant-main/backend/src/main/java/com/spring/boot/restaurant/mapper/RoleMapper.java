package com.spring.boot.restaurant.mapper;

import com.spring.boot.restaurant.dto.RoleDto;
import com.spring.boot.restaurant.model.Role;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);

    Role toEntity(RoleDto dto);

    List<RoleDto> toDtoList(List<Role> roles);

    List<Role> toEntityList(List<RoleDto> dtos);
}
