package com.spring.boot.resturantbackend.mappers.security;

import com.spring.boot.resturantbackend.dto.security.AccountDto;
import com.spring.boot.resturantbackend.models.security.Account;
import com.spring.boot.resturantbackend.controllers.vm.Security.AccountAuthRequestVm;
import com.spring.boot.resturantbackend.controllers.vm.Security.AccountAuthResponseVm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);

    AccountDto toAccountDto(Account account);

    Account toAccount(AccountDto accountDto);

    AccountDto toAccountDto(AccountAuthRequestVm accountAuthRequestVm);

    AccountAuthResponseVm toAccountResponseVm(AccountDto accountDto);

}
