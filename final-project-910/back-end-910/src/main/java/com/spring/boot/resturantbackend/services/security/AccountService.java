package com.spring.boot.resturantbackend.services.security;

import com.spring.boot.resturantbackend.dto.security.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAccounts();

    AccountDto createAccount(AccountDto accountDto);

    AccountDto updateAccount(AccountDto accountDto);

    void deleteAccount(Long id);

    AccountDto getAccountById(Long id);

    AccountDto getAccountByUsername(String username);

}
