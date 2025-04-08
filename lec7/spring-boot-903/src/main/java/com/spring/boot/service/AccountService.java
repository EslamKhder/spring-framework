package com.spring.boot.service;

import com.spring.boot.model.Account;
import jakarta.transaction.SystemException;

import java.util.List;

public interface AccountService {

    List<Account> getApplications();
    Account createAccount(Account account) throws SystemException;
    Account updateAccount(Account account) throws SystemException;
    boolean deleteAccount(Long id) throws SystemException;
    List<Account> search(String searchValue) throws SystemException;
    List<Account> getByPhone(String phone) throws SystemException;
}
