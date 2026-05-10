package com.spring.demo.service.impl;

import com.spring.demo.controller.vm.LoginResponseVM;
import com.spring.demo.dto.AccountDto;
import com.spring.demo.dto.TeacherDto;
import com.spring.demo.mapper.AccountMapper;
import com.spring.demo.mapper.TeacherMapper;
import com.spring.demo.model.Account;
import com.spring.demo.model.Teacher;
import com.spring.demo.repo.AccountRepo;
import com.spring.demo.repo.TeacherRepo;
import com.spring.demo.service.AccountService;
import com.spring.demo.service.TeacherService;
import com.spring.demo.service.token.JwtTokenHandler;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;
    private AccountMapper accountMapper;

    private JwtTokenHandler jwtTokenHandler;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, AccountMapper accountMapper, JwtTokenHandler jwtTokenHandler) {
        this.accountRepo = accountRepo;
        this.accountMapper = accountMapper;
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @Override
    public AccountDto getByUserName(String userName) throws SystemException {
        Optional<Account> accountOptional = accountRepo.findByUserName(userName);

        if (!accountOptional.isPresent()) {
            throw new SystemException("user name not exist");
        }

        return accountMapper.toDto(accountOptional.get());
    }

    @Override
    public LoginResponseVM login(AccountDto accountDto) throws SystemException {
        Optional<Account> accountOptional = accountRepo.findByUserName(accountDto.getUserName());

        if (!accountOptional.isPresent()) {
            throw new SystemException("user name not exist");
        }

        if (!accountDto.getPassword().equals(accountOptional.get().getPassword())){
            throw new SystemException("invalid password");
        }
        Account account = accountOptional.get();

        // create token
        String token = jwtTokenHandler.createToken(accountMapper.toDto(account));
        return new LoginResponseVM(token);
    }

    @Override
    public LoginResponseVM signup(AccountDto accountDto) {
        return null;
    }
}
