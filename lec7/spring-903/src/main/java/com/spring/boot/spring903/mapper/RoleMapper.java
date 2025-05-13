package com.spring.boot.spring903.mapper;



import com.spring.boot.spring903.dto.RoleDto;
import com.spring.boot.spring903.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper ROLE_MAPPER = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleDto roleDto);

    RoleDto toRoleDto(Role account);

    List<Role> toRoleList(List<RoleDto> roleDto);
    List<RoleDto> toRoleDtoList(List<Role> account);
}
