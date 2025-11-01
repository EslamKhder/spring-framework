package com.spring.boot908.mapper;

import com.spring.boot908.dto.RoleDto;
import com.spring.boot908.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleDto roleDto);

    RoleDto toDto(Role role);

    List<Role> toEntityList(List<RoleDto> roleDto);

    List<RoleDto> toDto(List<Role> roles);
}
