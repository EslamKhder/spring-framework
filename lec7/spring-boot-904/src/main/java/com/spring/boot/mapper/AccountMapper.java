package com.spring.boot.mapper;

import com.spring.boot.dto.AccountDto;
import com.spring.boot.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface AccountMapper {

    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);

    @Mapping(source = "specId", target = "id")

    Account toAccount(AccountDto accountDto);

    @Mapping(target = "address", ignore = true)
    @Mapping(source = "id", target = "specId")
    AccountDto toAccountDto(Account account);

    List<Account> toAccountList(List<AccountDto> accountDtos);
    List<AccountDto> toAccountDtoList(List<Account> accounts);
}
