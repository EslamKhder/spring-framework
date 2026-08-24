package start.group.demo910.service.impl;

import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.group.demo910.dto.AccountDto;
import start.group.demo910.mapper.AccountMapper;
import start.group.demo910.model.Account;
import start.group.demo910.repo.AccountRepo;
import start.group.demo910.service.AccountService;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;
    private AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, AccountMapper accountMapper) {
        this.accountRepo = accountRepo;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto getAccountByUser(String userName) throws SystemException {

        Optional<Account> account = accountRepo.findByUsername(userName);

        if (account.isEmpty()) {
            throw new SystemException("account.not.exist");
        }

        return accountMapper.toDto(account.get());
    }
}
