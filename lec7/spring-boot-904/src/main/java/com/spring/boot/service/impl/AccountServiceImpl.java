package com.spring.boot.service.impl;

import com.spring.boot.dto.exception.IdNotNullException;
import com.spring.boot.mapper.AccountMapper;
import org.modelmapper.ModelMapper;
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

//    @Autowired
//    private ModelMapper modelMapper;

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
    public void createAccount(AccountDto accountDto) throws SystemException, IdNotNullException {
        if (Objects.nonNull(accountDto.getSpecId())) {
            throw new IdNotNullException("error.id.null");
        }
        accountRepo.save(AccountMapper.ACCOUNT_MAPPER.toAccount(accountDto));
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) throws SystemException {
        if (Objects.isNull(accountDto.getSpecId())) {
            throw new SystemException("id must be not null");
        }
        Account accountSaved =  accountRepo.save(AccountMapper.ACCOUNT_MAPPER.toAccount(accountDto));
        return  AccountMapper.ACCOUNT_MAPPER.toAccountDto(accountSaved);
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
        return AccountMapper.ACCOUNT_MAPPER.toAccountDtoList(accounts);
    }
}
