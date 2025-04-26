package com.spring.boot.dto.security;

import com.spring.boot.dto.AccountDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private AccountDto accountDto;

    public CustomUserDetails(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return accountDto.getRoles().stream().map(roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return "{noop}" + accountDto.getPassword();
    }

    @Override
    public String getUsername() {
        return accountDto.getUserName();
    }
}
