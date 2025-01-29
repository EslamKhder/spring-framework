package com.spring.service.impl;

import com.spring.dto.CustomUserDetails;
import com.spring.model.Client;
import com.spring.service.ClientService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class CustomUserService /*implements UserDetailsService*/ {
/*
    //@Autowired
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Client client = clientService.getClientByEmail(username);

            return new CustomUserDetails(client);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }*/
}
