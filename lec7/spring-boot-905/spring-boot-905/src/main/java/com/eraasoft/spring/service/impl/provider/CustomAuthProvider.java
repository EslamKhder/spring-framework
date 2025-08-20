package com.eraasoft.spring.service.impl.provider;

import com.eraasoft.spring.dto.AccountDto;
import com.eraasoft.spring.mapper.AccountMapper;
import com.eraasoft.spring.model.Account;
import com.eraasoft.spring.repo.AccountRepo;
import com.eraasoft.spring.service.AccountService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Component
public class CustomAuthProvider implements AuthenticationProvider {


    private AccountService accountService;

    @Autowired
    public CustomAuthProvider(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        AccountDto accountDto = accountService.getByUserName(userName);

        if (!accountDto.getPassword().equals(password)){
            throw new RuntimeException("invalid password");
        }

        List<SimpleGrantedAuthority> roles = getAuthorities(accountDto);

        return new UsernamePasswordAuthenticationToken(userName, password, roles);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<SimpleGrantedAuthority> getAuthorities(AccountDto accountDto) {
        return accountDto.getRoles().stream().map(roleDto ->
                new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName())).collect(Collectors.toList());
    }
}
