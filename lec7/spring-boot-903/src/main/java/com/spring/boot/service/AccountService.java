package com.spring.boot.service;

import com.spring.boot.dto.AccountDto;
import com.spring.boot.exceptions.IdMisMatchException;
import jakarta.transaction.SystemException;

import java.util.List;

public interface AccountService {

    List<AccountDto> getApplications();
    AccountDto createAccount(AccountDto account) throws SystemException, IdMisMatchException;
    AccountDto updateAccount(AccountDto account) throws SystemException;
    boolean deleteAccount(Long id) throws SystemException;
    List<AccountDto> search(String searchValue) throws SystemException;
    List<AccountDto> getByPhone(String phone) throws SystemException;

    AccountDto getAccountByName(String name) throws SystemException;
}
