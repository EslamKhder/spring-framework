package com.spring.demo911.mapper;

import com.spring.demo911.controller.vm.PlayerResponseVM;
import com.spring.demo911.dto.AccountDto;
import com.spring.demo911.dto.PlayerDto;
import com.spring.demo911.model.Account;
import com.spring.demo911.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toEntity(AccountDto accountDto);

    AccountDto toDto(Account account);

    List<Account> toEntityList(List<AccountDto> accountDtos);

    List<AccountDto> toDtoList(List<Account> accounts);
}
