package com.spring.demo911.service.impl;

import com.spring.demo911.config.token.TokenHandler;
import com.spring.demo911.controller.vm.LoginRequest;
import com.spring.demo911.dto.AccountDto;
import com.spring.demo911.model.Account;
import com.spring.demo911.service.AccountService;
import com.spring.demo911.service.AuthService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    private AccountService accountService;

    private PasswordEncoder passwordEncoder;

    private TokenHandler tokenHandler;

    @Autowired
    public AuthServiceImpl(AccountService accountService, PasswordEncoder passwordEncoder, TokenHandler tokenHandler) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
        this.tokenHandler = tokenHandler;
    }

    @Override
    public String login(LoginRequest request) throws SystemException {
        try {
            AccountDto accountDto = accountService.getByEmail(request.getUsername());

            if (!passwordEncoder.matches(request.getPassword(), accountDto.getPassword())) {
                throw new SystemException("user.invalid.password");
            }

            return tokenHandler.createToken(accountDto);

        } catch (SystemException e) {
            throw new SystemException("user.invalid.data");
        }
    }
}
