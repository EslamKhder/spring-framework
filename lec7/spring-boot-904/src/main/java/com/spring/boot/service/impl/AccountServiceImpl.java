package com.spring.boot.service.impl;

import com.spring.boot.dto.AccountDto;
import com.spring.boot.model.Account;
import com.spring.boot.repo.AccountRepo;
import com.spring.boot.service.AccountService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;


    @Override
    public List<AccountDto> getAllAccount() {

        /*List<Account> accounts = accountRepo.findAll();

        List<AccountDto> accountDtos = new ArrayList<>();
        for(Account account: accounts){
            accountDtos.add(new AccountDto(
                    account.getId(),
                    account.getName(),
                    account.getPhone(),
                    account.getAddress()
            ));
        }*/
        return extractAccountDtos(accountRepo.findAll());
    }

    @Override
    public void createAccount(AccountDto account) throws SystemException {
        if (Objects.nonNull(account.getId())) {
            throw new SystemException("id must be null");
        }
        accountRepo.save(new Account(
                account.getName(),
                account.getPhone(),
                account.getAddress()
        ));
    }

    @Override
    public AccountDto updateAccount(AccountDto account) throws SystemException {
        if (Objects.isNull(account.getId())) {
            throw new SystemException("id must be not null");
        }
        Account accountSaved =  accountRepo.save(new Account(
                account.getId(),
                account.getName(),
                account.getPhone(),
                account.getAddress()
        ));

        return AccountDto.getAccountDto(accountSaved);
    }

    @Override
    public void removeAccount(Long id) throws SystemException {
        Optional<Account> account = accountRepo.findById(id);
        if (!account.isPresent()) {
            throw new SystemException("Account not found with id " + id);
        }
        accountRepo.deleteById(id);
    }

    @Override
    public List<AccountDto> getAllAccountByName(String name) {
        return extractAccountDtos(accountRepo.findByName(name));
    }

    @Override
    public List<AccountDto> search(String name) {
        return extractAccountDtos(accountRepo.search(name));
    }


    private List<AccountDto> extractAccountDtos(List<Account> accounts) {
        return accounts.stream().map(account -> AccountDto.getAccountDto(account)).collect(Collectors.toList());
    }
}
