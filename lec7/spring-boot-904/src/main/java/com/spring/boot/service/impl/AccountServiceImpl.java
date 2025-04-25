package com.spring.boot.service.impl;

import com.spring.boot.model.Account;
import com.spring.boot.repo.AccountRepo;
import com.spring.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;


    @Override
    public List<Account> getAllAccount() {
        return accountRepo.findAll();
    }

    @Override
    public void createAccount(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void removeAccount(Long id) {
        accountRepo.deleteById(id);
    }

    @Override
    public List<Account> getAllAccountByName(String name) {
        return accountRepo.findByName(name);
    }

    @Override
    public List<Account> search(String name) {
        return accountRepo.search(name);
    }
}
