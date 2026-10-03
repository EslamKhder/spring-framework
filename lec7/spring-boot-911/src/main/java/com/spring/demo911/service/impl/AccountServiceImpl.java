package com.spring.demo911.service.impl;

import com.spring.demo911.dto.AccountDto;
import com.spring.demo911.mapper.AccountMapper;
import com.spring.demo911.mapper.RoleMapper;
import com.spring.demo911.model.Account;
import com.spring.demo911.repo.AccountRepo;
import com.spring.demo911.service.AccountService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;

    private AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, AccountMapper accountMapper) {
        this.accountRepo = accountRepo;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto getByEmail(String email) throws SystemException {

        Optional<Account> accountOptional = accountRepo.findByEmail(email);

        if (accountOptional.isEmpty()) {
            throw new SystemException("account.not.exist");
        }

        return accountMapper.toDto(accountOptional.get());
    }
}
