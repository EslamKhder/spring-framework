package com.spring.boot.service.impl;

import com.spring.boot.dto.AccountDto;
import com.spring.boot.dto.RoleDto;
import com.spring.boot.exceptions.IdMisMatchException;
import com.spring.boot.mapper.AccountMapper;
import com.spring.boot.mapper.RoleMapper;
import com.spring.boot.model.Account;
import com.spring.boot.model.Role;
import com.spring.boot.repo.AccountRepo;
import com.spring.boot.repo.RoleRepo;
import com.spring.boot.service.AccountService;
import com.spring.boot.service.RoleService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
