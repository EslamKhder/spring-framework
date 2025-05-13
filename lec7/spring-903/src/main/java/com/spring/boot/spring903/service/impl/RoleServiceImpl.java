package com.spring.boot.spring903.service.impl;

import com.spring.boot.spring903.dto.RoleDto;
import com.spring.boot.spring903.mapper.RoleMapper;
import com.spring.boot.spring903.model.Role;
import com.spring.boot.spring903.repo.RoleRepo;
import com.spring.boot.spring903.service.RoleService;
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
    public RoleDto getRoleByName(String role) throws SystemException {
        Optional<Role> existedRole = roleRepo.findByRole(role);
        if (!existedRole.isPresent()) {
            throw new SystemException("role not exist for : " + role);
        }
        return RoleMapper.ROLE_MAPPER.toRoleDto(existedRole.get());
    }

    @Override
    public List<RoleDto> update(List<Role> roles) throws SystemException {
        return RoleMapper.ROLE_MAPPER.toRoleDtoList(roleRepo.saveAll(roles));
    }
}
