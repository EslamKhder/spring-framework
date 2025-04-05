package com.spring.restaurant.service.Jwt;

import com.spring.restaurant.config.Jwt.TokenHandler;
import com.spring.restaurant.mapper.RoleMapper;
import com.spring.restaurant.model.clientmodels.Client;
import com.spring.restaurant.service.dto.Jwt.ClientLoginDto;
import com.spring.restaurant.service.dto.Jwt.TokenDto;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        List<String> rolse = client.getRoles().stream().map(role -> role.getCode().substring(5)).collect(Collectors.toList());
        return new TokenDto(tokenHandler.createToken(client), rolse);
    }
}
