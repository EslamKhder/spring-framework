package com.spring.demo.service.provider;

import com.spring.demo.dto.AccountDto;
import com.spring.demo.model.Role;
import com.spring.demo.service.AccountService;
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
import java.util.stream.Collectors;

@Component
public class AuthProvider implements AuthenticationProvider {

    public static final String ROLE = "ROLE_";
    private AccountService accountService;
    private PasswordEncoder passwordEncoder;



    @Autowired
    public AuthProvider(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        try {
            AccountDto accountDto = accountService.getByUserName(userName);

            if (!accountDto.getPassword().equals(password) && !passwordEncoder.matches(password, accountDto.getPassword())) {
                throw new SystemException("invalid password");
            }

            return new UsernamePasswordAuthenticationToken(userName, password, getAuthorities(accountDto.getRoles()));

        } catch (SystemException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(ROLE + role.getRole())).collect(Collectors.toList());
    }
}
