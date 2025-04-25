package com.spring.boot.service;

import com.spring.boot.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccount();

    void createAccount(Account account);
    void updateAccount(Account account);

    void removeAccount(Long id);

    List<Account> getAllAccountByName(String name);

    List<Account> search(String name);
}
