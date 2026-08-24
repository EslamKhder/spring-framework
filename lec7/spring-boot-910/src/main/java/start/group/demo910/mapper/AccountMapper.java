package start.group.demo910.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import start.group.demo910.controller.vm.PlayerVM;
import start.group.demo910.dto.AccountDto;
import start.group.demo910.dto.PlayerDto;
import start.group.demo910.model.Account;
import start.group.demo910.model.Player;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto(Account account);

    Account toEntity(AccountDto accountDto);

    List<AccountDto> toDtoList(List<Account> accounts);

    List<Account> toEntityList(List<AccountDto> accountsDto);

}