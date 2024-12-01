package com.spring.service.impl;


import com.spring.config.jwt.TokenHandler;
import com.spring.dto.UserLoginDto;
import com.spring.model.Client;
import com.spring.service.ClientService;
import com.spring.service.UserAuthService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private TokenHandler tokenHandler;

    @Override
    public String login(UserLoginDto userLoginDto) throws SystemException {
        Client client = clientService.getClientByEmail(userLoginDto.getEmail());

        if (!client.getPassword().equals(userLoginDto.getPassword())) {
            throw new BadCredentialsException("Invalid Password");
        }

        return tokenHandler.createToken(client);
    }
}
