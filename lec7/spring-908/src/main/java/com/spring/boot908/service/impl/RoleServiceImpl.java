package com.spring.boot908.service.impl;

import com.spring.boot908.dto.RoleDto;
import com.spring.boot908.mapper.RoleMapper;
import com.spring.boot908.model.Role;
import com.spring.boot908.repo.RoleRepo;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepo roleRepo;

    private RoleMapper roleMapper;


    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo, RoleMapper roleMapper) {
        this.roleRepo = roleRepo;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDto findByCode(String code) throws SystemException {
        Optional<Role> role = roleRepo.findByCode(code);

        if (!role.isPresent()) {
            throw new SystemException("role.not.exist");
        }

        return roleMapper.toDto(role.get());
    }
}
