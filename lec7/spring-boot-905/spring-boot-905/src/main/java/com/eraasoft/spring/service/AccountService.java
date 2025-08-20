package com.eraasoft.spring.service;


import com.eraasoft.spring.dto.AccountDto;

public interface AccountService {


    AccountDto getByUserName(String userName);
    AccountDto createAccount(AccountDto accountDto);

}
