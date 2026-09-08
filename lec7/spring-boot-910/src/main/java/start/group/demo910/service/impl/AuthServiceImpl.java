package start.group.demo910.service.impl;

import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import start.group.demo910.dto.AccountDto;
import start.group.demo910.service.AccountService;
import start.group.demo910.service.AuthService;
import start.group.demo910.service.token.TokenHandler;

@Service
public class AuthServiceImpl implements AuthService {

    private AccountService accountService;

    private TokenHandler tokenHandler;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AccountService accountService, TokenHandler tokenHandler, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.tokenHandler = tokenHandler;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String login(AccountDto accountDto) throws SystemException {

        AccountDto existingAccountDto = accountService.getAccountByUser(accountDto.getUsername());

        boolean isPasswordNotMatchV1 = !passwordEncoder.matches(accountDto.getPassword(), existingAccountDto.getPassword());
        boolean isPasswordNotMatchV2 = !existingAccountDto.getPassword().equals(accountDto.getPassword());
        if (isPasswordNotMatchV1 && isPasswordNotMatchV2) {
            throw new SystemException("invalid password");
        }

        return tokenHandler.createToken(existingAccountDto);
    }
}
