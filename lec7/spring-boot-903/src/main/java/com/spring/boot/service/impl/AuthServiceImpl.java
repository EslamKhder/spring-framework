package com.spring.boot.service.impl;

import com.spring.boot.config.TokenHandler;
import com.spring.boot.controller.vm.AccountRequestVm;
import com.spring.boot.controller.vm.AccountResponseVm;
import com.spring.boot.dto.AccountDto;
import com.spring.boot.enms.Role;
import com.spring.boot.service.AccountService;
import com.spring.boot.service.AuthService;
import com.spring.boot.service.RoleService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountResponseVm login(AccountRequestVm accountRequestVm) {
        try {
            AccountDto accountDto = accountService.getAccountByName(accountRequestVm.getUserName());

            if(!passwordEncoder.matches(accountRequestVm.getPassword(), accountDto.getPassword())){
                throw new SystemException("invalid password");
            }

            return new AccountResponseVm(tokenHandler.createToken(accountDto));
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AccountResponseVm addAccount(AccountDto accountDto) {
        try {
            accountDto.setRoles(List.of(roleService.getRoleByName(Role.USER.toString())));
            accountDto = accountService.createAccount(accountDto);
            return new AccountResponseVm(tokenHandler.createToken(accountDto));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
