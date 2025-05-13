package com.spring.boot.spring903.service.impl;

import com.spring.boot.spring903.config.TokenHandler;
import com.spring.boot.spring903.controller.vm.AccountRequestVm;
import com.spring.boot.spring903.controller.vm.AccountResponseVm;
import com.spring.boot.spring903.dto.AccountDto;
import com.spring.boot.spring903.service.AccountService;
import com.spring.boot.spring903.service.AuthService;
import com.spring.boot.spring903.service.RoleService;
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
            accountDto.setRoles(List.of(roleService.getRoleByName("USER")));
            accountDto = accountService.createAccount(accountDto);
            return new AccountResponseVm(tokenHandler.createToken(accountDto));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
