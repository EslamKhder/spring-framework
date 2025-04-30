package com.spring.boot.service;

import com.spring.boot.controller.vm.AccountResponseVm;
import com.spring.boot.dto.AccountDto;
import com.spring.boot.model.Account;
import jakarta.transaction.SystemException;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAllAccount();
//    List<AccountResponseVm> getSpecAccount();

    void createAccount(AccountDto account) throws SystemException;
    AccountDto updateAccount(AccountDto account) throws SystemException;

    void removeAccount(Long id) throws SystemException;

    List<AccountDto> getAllAccountByName(String name);

    List<AccountDto> search(String name);
}
