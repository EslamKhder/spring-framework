package com.spring.boot.resturantbackend.services.security;

import com.spring.boot.resturantbackend.dto.security.UserDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface AccountService {
    List<UserDto> getAccounts() throws SystemException;

    UserDto createAccount(UserDto userDto) throws SystemException;

    UserDto updateAccount(UserDto userDto) throws SystemException;

    void deleteAccount(Long id) throws SystemException;

    UserDto getAccountById(Long id) throws SystemException;

    UserDto getAccountByUsername(String username) throws SystemException;

}
