package com.spring.boot.resturantbackend.services.impl.security;

import com.spring.boot.resturantbackend.dto.security.RoleDto;
import com.spring.boot.resturantbackend.mappers.security.RoleMapper;
import com.spring.boot.resturantbackend.models.security.RoleEntity;
import com.spring.boot.resturantbackend.repositories.security.RoleRepo;
import com.spring.boot.resturantbackend.services.security.RoleService;
import com.spring.boot.resturantbackend.vm.Security.RoleDtoVm;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public RoleDtoVm findByRole(String role) {
        try {
            Optional<RoleEntity> roleResult = roleRepo.findByCode(role);
            if (roleResult.isEmpty()) {
                throw new SystemException("error.role.not.found");
            }
            return RoleMapper.ROLE_MAPPER.toRoleDtoVm(roleResult.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public RoleDto getRole(String role) {
        try {
            Optional<RoleEntity> roleResult = roleRepo.findByCode(role);
            if (roleResult.isEmpty()) {
                throw new SystemException("error.role.not.found");
            }
            roleResult.get().getUsers().stream().forEach(userDto1 -> userDto1.setRoles(null));
            return RoleMapper.ROLE_MAPPER.toRoleDto(roleResult.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RoleDto> update(List<RoleEntity> roles) {
        try {
            List<RoleEntity> rolesResult = roleRepo.saveAll(roles);
            if (rolesResult.isEmpty()) {
                throw new SystemException("error.role.not.found");
            }
            return roles.stream().map(RoleMapper.ROLE_MAPPER::toRoleDto).toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(RoleDto role) {
        roleRepo.save(RoleMapper.ROLE_MAPPER.toRole(role));
    }
}
