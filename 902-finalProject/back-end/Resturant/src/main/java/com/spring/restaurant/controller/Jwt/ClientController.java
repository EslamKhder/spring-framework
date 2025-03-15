package com.spring.restaurant.controller.Jwt;

import com.spring.restaurant.service.Jwt.AuthService;
import com.spring.restaurant.service.Jwt.ClientService;
import com.spring.restaurant.service.dto.Jwt.ClientDto;
import com.spring.restaurant.service.dto.Jwt.ClientLoginDto;
import com.spring.restaurant.service.dto.Jwt.TokenDto;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/login")
    ResponseEntity<TokenDto>login(@RequestBody ClientLoginDto clientLoginDto) throws SystemException {
       return ResponseEntity.ok(authService.login(clientLoginDto));
    }

    @PostMapping("/create-client")
    ResponseEntity<Void> createUser(@RequestBody ClientDto clientDto) throws SystemException {
        clientService.createUserClient(clientDto);
        return  ResponseEntity.created(URI.create("/client/addClientWithRole")).build();
    }
}
