package com.spring.boot.service.impl;

import com.spring.boot.dto.AccountDto;
import com.spring.boot.dto.security.CustomUserDetails;
import com.spring.boot.service.AccountService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            AccountDto accountDto = accountService.getAccountByName(username);
            return new CustomUserDetails(accountDto);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }
}
