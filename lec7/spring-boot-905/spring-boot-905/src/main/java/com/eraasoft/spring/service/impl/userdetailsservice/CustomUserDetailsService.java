package com.eraasoft.spring.service.impl.userdetailsservice;

import com.eraasoft.spring.dto.AccountDto;
import com.eraasoft.spring.service.AccountService;
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
        AccountDto accountDto = accountService.getByUserName(username);

        return new CustomUserDetails(accountDto); // pass , roles
    }
}
