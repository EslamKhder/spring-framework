package com.spring.demo911.service.impl;

import com.spring.demo911.dto.AccountDto;
import com.spring.demo911.helper.CustomUserDetails;
import com.spring.demo911.model.Account;
import com.spring.demo911.service.AccountService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class CustomUserDetailsService implements UserDetailsService {

    private AccountService accountService;

    @Autowired
    public CustomUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            AccountDto accountDto = accountService.getByEmail(username);
            return new CustomUserDetails(accountDto);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }

    }

}
