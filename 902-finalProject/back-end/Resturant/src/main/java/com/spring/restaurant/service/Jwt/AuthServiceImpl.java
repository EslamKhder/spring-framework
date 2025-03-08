package com.spring.restaurant.service.Jwt;

import com.spring.restaurant.config.Jwt.TokenHandler;
import com.spring.restaurant.model.clientmodels.Client;
import com.spring.restaurant.service.dto.Jwt.ClientLoginDto;
import com.spring.restaurant.service.dto.Jwt.TokenDto;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
   @Autowired
    private ClientService clientService;

   @Autowired
    private TokenHandler tokenHandler;

   @Autowired
   private PasswordEncoder passwordEncoder;

    @Override
    public TokenDto login(ClientLoginDto clientLoginDto) throws SystemException {
        Client client = clientService.getClientbyEmail(clientLoginDto.getEmail());

        if (!passwordEncoder.matches(clientLoginDto.getPassword(),client.getPassword())) {
            throw new BadCredentialsException("error.clientNotExist");
        }

        return new TokenDto(tokenHandler.createToken(client));
    }
}
