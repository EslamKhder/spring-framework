package com.spring.boot.mapper;

import com.spring.boot.dto.RoleDto;
import com.spring.boot.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper ROLE_MAPPER = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleDto roleDto);

    RoleDto toRoleDto(Role role);

    List<Role> toRoleList(List<RoleDto> roleDtos);
    List<RoleDto> toRoleDtoList(List<Role> roles);
}
