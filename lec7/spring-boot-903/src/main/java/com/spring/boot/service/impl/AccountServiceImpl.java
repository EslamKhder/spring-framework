package com.spring.boot.service.impl;

import com.spring.boot.model.Account;
import com.spring.boot.repo.AccountRepo;
import com.spring.boot.service.AccountService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public List<Account> getApplications() {
        return accountRepo.findAll();
    }

    @Override
    public Account createAccount(Account account) throws SystemException {
        if (Objects.nonNull(account.getId())) {
            throw new SystemException("id must be null");
        }

        Optional<Account> accountExist = accountRepo.findByUserName(account.getUserName());

        if (accountExist.isPresent()) {
            throw new SystemException("there exist account with same username: " + account.getUserName());
        }

        return accountRepo.save(account);
    }

    @Override
    public Account updateAccount(Account account) throws SystemException {
        if (Objects.isNull(account.getId())) {
            throw new SystemException("id must be not null");
        }

        checkAccountExist(account.getId());

        return accountRepo.save(account);
    }

    @Override
    public boolean deleteAccount(Long id) throws SystemException {
        Optional<Account> optionalAccount = accountRepo.findById(id);
        if (optionalAccount.isEmpty()) {
            return false;
        }
        accountRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Account> search(String searchValue) throws SystemException {
        if (Objects.isNull(searchValue)) {
            throw new SystemException("searchValue must be not null");
        }
        return accountRepo.findByUserNameContainingIgnoreCase(searchValue);
    }

    @Override
    public List<Account> getByPhone(String phone) throws SystemException {
        if (Objects.isNull(phone)) {
            throw new SystemException("searchValue must be not null");
        }
        return accountRepo.findByAccountPhoneV2(phone);
    }

    private void checkAccountExist(Long id) throws SystemException {
        Optional<Account> optionalAccount = accountRepo.findById(id);

        if (optionalAccount.isEmpty()) {
            throw new SystemException("account not exist with id " + id);
        }
    }
}
