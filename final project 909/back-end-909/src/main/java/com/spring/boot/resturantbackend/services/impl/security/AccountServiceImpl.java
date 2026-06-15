package com.spring.boot.resturantbackend.services.impl.security;

import com.spring.boot.resturantbackend.dto.security.AccountDto;
import com.spring.boot.resturantbackend.mappers.security.RoleMapper;
import com.spring.boot.resturantbackend.mappers.security.AccountMapper;
import com.spring.boot.resturantbackend.models.security.Account;
import com.spring.boot.resturantbackend.models.security.Role;
import com.spring.boot.resturantbackend.repositories.security.AccountRepo;
import com.spring.boot.resturantbackend.services.security.AccountService;
import com.spring.boot.resturantbackend.services.security.RoleService;
import com.spring.boot.resturantbackend.utils.RoleEnum;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    @Override
    public List<AccountDto> getAccounts() {
        try {
            List<Account> users = accountRepo.findAll();
            if (users.isEmpty()) {
                throw new SystemException("empty.accounts");
            }
            return users.stream().map(AccountMapper.ACCOUNT_MAPPER::toAccountDto).collect(Collectors.toList());
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        try {
            validateCreateAccount(accountDto);
            //enable account
            accountDto.setEnabled("1");
            Account user = AccountMapper.ACCOUNT_MAPPER.toAccount(accountDto);
            //encode password
            user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
            //make relation between user and role
            initRoleToUser(user);
            user = accountRepo.save(user);
            return AccountMapper.ACCOUNT_MAPPER.toAccountDto(user);
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void initRoleToUser(Account user) {
        Role role = RoleMapper.ROLE_MAPPER.toRole(roleService.findByRole(RoleEnum.USER.toString()));
        List<Role> roles = user.getRoles();
        if (Objects.isNull(roles)) {
            roles = new ArrayList<>();
        }
        roles.add(role);
        user.setRoles(roles);
    }

    private void validateCreateAccount(AccountDto accountDto) throws SystemException {
        if (Objects.nonNull(accountDto.getId())) {
            throw new SystemException("id.must_be.null");
        }
        if (Objects.nonNull(getAccountByUsername(accountDto.getUsername()))) {
            throw new SystemException("account.exists");
        }
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        try {
            validateUpdateAccount(accountDto.getId());
            Account account = AccountMapper.ACCOUNT_MAPPER.toAccount(accountDto);
            account = accountRepo.save(account);
            return AccountMapper.ACCOUNT_MAPPER.toAccountDto(account);
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void validateUpdateAccount(Long id) throws SystemException {
        if (Objects.isNull(id)) {
            throw new SystemException("id.must_be.not_null");
        }
        if (Objects.isNull(getAccountById(id))) {
            throw new SystemException("not_found.account");
        }
    }

    @Override
    public void deleteAccount(Long id) {
        try {
            validateUpdateAccount(id);
            accountRepo.deleteById(id);
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public AccountDto getAccountById(Long id) {
        try {
            if (Objects.isNull(id)) {
                throw new SystemException("id.must_be.not_null");
            }
            Optional<Account> result = accountRepo.findById(id);
            if (result.isEmpty()) {
                throw new SystemException("not_found.account");
            }
            return AccountMapper.ACCOUNT_MAPPER.toAccountDto(result.get());
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public AccountDto getAccountByUsername(String username) {
        try {
            if (username.isEmpty()) {
                throw new SystemException("not_empty.name");
            }
            Optional<Account> result = accountRepo.findByUsername(username);
            if (result.isEmpty()) {
                return null;
            }
            return AccountMapper.ACCOUNT_MAPPER.toAccountDto(result.get());
        } catch (SystemException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
