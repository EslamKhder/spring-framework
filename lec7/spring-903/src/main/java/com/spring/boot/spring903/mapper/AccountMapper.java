package com.spring.boot.spring903.mapper;

import com.spring.boot.spring903.dto.AccountDto;
import com.spring.boot.spring903.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);

    Account toAccount(AccountDto accountDto);

//    @Mapping(target = "password", ignore = true)
    @Mapping(source = "roles", target = "roles")
    AccountDto toAccountDto(Account account);

    List<Account> toAccountList(List<AccountDto> accountDto);
    List<AccountDto> toAccountDtoList(List<Account> account);
}
