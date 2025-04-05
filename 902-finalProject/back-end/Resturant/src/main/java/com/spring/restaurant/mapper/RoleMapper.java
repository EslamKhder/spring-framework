package com.spring.restaurant.mapper;

import com.spring.restaurant.model.clientmodels.Role;
import com.spring.restaurant.service.dto.Jwt.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper ROLE_MAPPER = Mappers.getMapper(RoleMapper.class);

    Role toEntity(RoleDto roleDto);
    RoleDto toDto(Role role);


    List<Role> toEntityList(List<RoleDto> roleDtos);
    List<RoleDto> toDtoList(List<Role>  roles);
}

