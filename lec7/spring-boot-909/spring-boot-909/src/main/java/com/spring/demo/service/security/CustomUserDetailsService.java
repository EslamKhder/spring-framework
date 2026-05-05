package com.spring.demo.service.security;

import com.spring.demo.dto.AccountDto;
import com.spring.demo.model.Account;
import com.spring.demo.service.AccountService;
import com.spring.demo.service.helper.CustomUserDetails;
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
            AccountDto accountDto = accountService.getByUserName(username); //
            return new CustomUserDetails(accountDto); // us pas roles
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }
}
