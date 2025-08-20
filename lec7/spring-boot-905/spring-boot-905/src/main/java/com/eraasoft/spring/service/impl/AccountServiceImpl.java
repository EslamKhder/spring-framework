package com.eraasoft.spring.service.impl;

import com.eraasoft.spring.dto.AccountDto;
import com.eraasoft.spring.dto.RoleDto;
import com.eraasoft.spring.mapper.AccountMapper;
import com.eraasoft.spring.model.Account;
import com.eraasoft.spring.model.Role;
import com.eraasoft.spring.repo.AccountRepo;
import com.eraasoft.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;
    private AccountMapper accountMapper;

    private PasswordEncoder passwordEncoder;


    public AccountServiceImpl(AccountRepo accountRepo, AccountMapper accountMapper, @Lazy PasswordEncoder passwordEncoder) {
        this.accountRepo = accountRepo;
        this.accountMapper = accountMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AccountDto getByUserName(String userName) {

        Optional<Account> account = accountRepo.findByUserName(userName);

        if (!account.isPresent()) {
            throw new RuntimeException("user name not exist");
        }

        return accountMapper.toAccountDto(account.get());
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        if (accountRepo.findByUserName(accountDto.getUserName()).isPresent()) {
            throw new RuntimeException("user name exist");
        }

        Account account = accountMapper.toAccount(accountDto);

        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));

        List<Role> roles = Collections.singletonList(new Role("USER", account));
        account.setRoles(roles);

        return accountMapper.toAccountDto(accountRepo.save(account));
    }
}
