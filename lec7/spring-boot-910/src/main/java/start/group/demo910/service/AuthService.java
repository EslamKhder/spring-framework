package start.group.demo910.service;

import jakarta.transaction.SystemException;
import start.group.demo910.dto.AccountDto;

public interface AuthService {

    String login(AccountDto accountDto) throws SystemException;
}
