package com.spring.demo.service.helper;

import com.spring.demo.dto.AccountDto;
import jakarta.transaction.SystemException;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    public static final String ROLE = "ROLE_";
    public final String NOOP = "{noop}";
    private AccountDto accountDto;

    public CustomUserDetails(AccountDto accountDto) throws SystemException {
        if (Objects.isNull(accountDto)) {
            throw new SystemException("account must be not null");
        }
        this.accountDto = accountDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return accountDto.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority( ROLE + role.getRole())).collect(Collectors.toList());
    }

    @Override
    public @Nullable String getPassword() {
        return NOOP + accountDto.getPassword();
    }

    @Override
    public String getUsername() {
        return accountDto.getUserName();
    }
}
