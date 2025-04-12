package com.spring.boot.service.impl;

import com.spring.boot.dto.AccountDto;
import com.spring.boot.mapper.AccountMapper;
import com.spring.boot.model.Account;
import com.spring.boot.repo.AccountRepo;
import com.spring.boot.service.AccountService;
import jakarta.transaction.SystemException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;


    @Override
    public List<AccountDto> getApplications() {

        List<Account> accounts = accountRepo.findAll();

        return extractAccounts(accounts);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) throws SystemException {
        if (Objects.nonNull(accountDto.getId())) {
            throw new SystemException("id must be null");
        }

        Optional<Account> accountExist = accountRepo.findByUserName(accountDto.getUserName());

        if (accountExist.isPresent()) {
            throw new SystemException("there exist account with same username: " + accountDto.getUserName());
        }

        Account account = AccountMapper.ACCOUNT_MAPPER.toAccount(accountDto);
//        Account account = modelMapper.map(accountDto, Account.class);
        /*Account account = new Account();
        account.setUserName(accountDto.getUserName());
        account.setPassword(accountDto.getPassword());
        account.setPhoneNumber(accountDto.getPhoneNumber());*/

        accountRepo.save(account);
        return accountDto;
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) throws SystemException {
        if (Objects.isNull(accountDto.getId())) {
            throw new SystemException("id must be not null");
        }

        checkAccountExist(accountDto.getId());

        Account account = AccountMapper.ACCOUNT_MAPPER.toAccount(accountDto);
//        Account account = modelMapper.map(accountDto, Account.class);
        /*
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setUserName(accountDto.getUserName());
        account.setPassword(accountDto.getPassword());
        account.setPhoneNumber(accountDto.getPhoneNumber());
*/
        accountRepo.save(account);
        return accountDto;
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
    public List<AccountDto> search(String searchValue) throws SystemException {
        if (Objects.isNull(searchValue)) {
            throw new SystemException("searchValue must be not null");
        }
        List<Account> accounts = accountRepo.findByUserNameContainingIgnoreCase(searchValue);

        return extractAccounts(accounts);
    }

    @Override
    public List<AccountDto> getByPhone(String phone) throws SystemException {
        if (Objects.isNull(phone)) {
            throw new SystemException("searchValue must be not null");
        }
        List<Account> accounts = accountRepo.findByAccountPhoneV2(phone);

        return extractAccounts(accounts);
    }

    private void checkAccountExist(Long id) throws SystemException {
        Optional<Account> optionalAccount = accountRepo.findById(id);

        if (optionalAccount.isEmpty()) {
            throw new SystemException("account not exist with id " + id);
        }
    }


    private List<AccountDto> extractAccounts(List<Account> accounts) {
        List<AccountDto> accountVMS = new ArrayList<>();
        for (Account ac : accounts) {
            AccountDto accountDto = AccountMapper.ACCOUNT_MAPPER.toAccountDto(ac);
//            accountDto.setPassword(null);
            /*
            AccountDto accountDto = new AccountDto();
            accountDto.setId(ac.getId());
            accountDto.setUserName(ac.getUserName());
            accountDto.setPhoneNumber(ac.getPhoneNumber());
            accountDto.setLength(String.valueOf(ac.getUserName().length()));
*/
            accountVMS.add(accountDto);
        }
        return accountVMS;
    }
}
