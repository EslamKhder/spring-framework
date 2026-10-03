package com.spring.demo911.service;

import com.spring.demo911.dto.AccountDto;
import com.spring.demo911.model.Account;
import jakarta.transaction.SystemException;

public interface AccountService {

    AccountDto getByEmail(String email) throws SystemException;

}
