package com.spring.demo.mapper;

import com.spring.demo.dto.AccountDto;
import com.spring.demo.dto.TeacherDto;
import com.spring.demo.model.Account;
import com.spring.demo.model.Teacher;
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
