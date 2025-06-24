package com.spring.boot.resturantbackend.services.impl.security;

import com.spring.boot.resturantbackend.config.security.TokenHandler;
import com.spring.boot.resturantbackend.dto.security.AccountDto;
import com.spring.boot.resturantbackend.mappers.security.AccountMapper;
import com.spring.boot.resturantbackend.services.security.AccountService;
import com.spring.boot.resturantbackend.services.security.AuthService;
import com.spring.boot.resturantbackend.controllers.vm.Security.AccountAuthRequestVm;
import com.spring.boot.resturantbackend.controllers.vm.Security.AccountAuthResponseVm;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TokenHandler tokenHandler;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountAuthResponseVm signUp(AccountAuthRequestVm accountAuthRequestVm) {
        AccountDto accountDto = AccountMapper.ACCOUNT_MAPPER.toAccountDto(accountAuthRequestVm);
        accountDto = accountService.createAccount(accountDto);
        AccountAuthResponseVm accountAuthResponseVm = AccountMapper.ACCOUNT_MAPPER.toAccountResponseVm(accountDto);
        accountAuthResponseVm.setToken(tokenHandler.generateToken(accountDto));
        accountAuthResponseVm.setUserRoles(getAccountRoles(accountDto));
        return accountAuthResponseVm;
    }

    @Override
    public AccountAuthResponseVm login(AccountAuthRequestVm accountAuthRequestVm) {
        try {
            AccountDto accountDto = accountService.getAccountByUsername(accountAuthRequestVm.getUsername());
            if (Objects.isNull(accountDto)) {
                throw new SystemException("not_found.account");
            }
            if (!passwordEncoder.matches(accountAuthRequestVm.getPassword(), accountDto.getPassword())) {
                throw new SystemException("error.invalid.credentials");
            }
            AccountAuthResponseVm accountAuthResponseVm = AccountMapper.ACCOUNT_MAPPER.toAccountResponseVm(accountDto);
            accountAuthResponseVm.setToken(tokenHandler.generateToken(accountDto));
            accountAuthResponseVm.setUserRoles(getAccountRoles(accountDto));
            return accountAuthResponseVm;
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private List<String> getAccountRoles(AccountDto accountDto) {
        return accountDto.getRoles().stream().map(roleDto -> roleDto.getRole()).collect(Collectors.toList());
    }
}
