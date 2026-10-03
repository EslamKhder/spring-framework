package com.spring.demo911.helper;

import com.spring.demo911.dto.AccountDto;
import jakarta.transaction.SystemException;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private AccountDto accountDto;

    public CustomUserDetails(AccountDto accountDto) throws SystemException {
        if (Objects.isNull(accountDto)) {
            throw new SystemException("invalid account data");
        }
        this.accountDto = accountDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return accountDto.getRoles().stream()
                .map(roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public @Nullable String getPassword() {
        return "{noop}" + accountDto.getPassword();
    }

    @Override
    public String getUsername() {
        return accountDto.getEmail();
    }
}
