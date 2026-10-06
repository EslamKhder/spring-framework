package com.spring.demo911.service.provider;

import com.spring.demo911.dto.AccountDto;
import com.spring.demo911.dto.RoleDto;
import com.spring.demo911.model.Account;
import com.spring.demo911.service.AccountService;
import jakarta.transaction.SystemException;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AuthProvider implements AuthenticationProvider {

    private AccountService accountService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthProvider(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        AccountDto accountDto = null;
        try {
            accountDto = accountService.getByEmail(email);

            if (Objects.isNull(accountDto)) {
                return null;
            }

            if (!accountDto.getEmail().startsWith("eslam")) {
                return null;
            }

            // password   999
            // accountDto.getPassword() = $2a$12$cAPK/XYvBjRXUk6myjNn9O91aZ64lAd7EDtHmyuJM1b4iE7hAIM9m
            boolean isNoopPasswordValid = password.equals(accountDto.getPassword());// false

            // false
            boolean isHashPasswordValid = passwordEncoder.matches(password, accountDto.getPassword());

            if (!isNoopPasswordValid && !isHashPasswordValid) {
                return null;
            }
            //            if (!password.equals(accountDto.getPassword())) {
//                return null;
//            }
//            if (!passwordEncoder.matches(password, accountDto.getPassword())) {
//                return null;
//            }

            if (accountDto.getRoles().isEmpty()) {
                return null;
            }

            // user verified
            return new UsernamePasswordAuthenticationToken(accountDto.getEmail(), accountDto.getPassword(),getAuthorities(accountDto.getRoles()));
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<RoleDto> roleDtos) {
        return roleDtos.stream()
                .map(roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName()))
                .collect(Collectors.toList());
    }
}
