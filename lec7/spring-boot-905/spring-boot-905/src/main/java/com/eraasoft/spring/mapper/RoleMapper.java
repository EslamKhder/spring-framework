package com.eraasoft.spring.mapper;

import com.eraasoft.spring.dto.RoleDto;
import com.eraasoft.spring.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {


    Role toRole(RoleDto roleDto);

    RoleDto toRoleDto(Role role);

    List<Role> toRoleList(List<RoleDto> roleDtos);
    List<RoleDto> toRoleDtoList(List<Role> roles);
}
