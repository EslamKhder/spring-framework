package com.spring.config;

import com.spring.dto.CustomUserDetails;
import com.spring.model.Auth;
import com.spring.model.Client;
import com.spring.service.ClientService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private ClientService clientService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            Client client = clientService.getClientByEmail(userName);

            if (!client.getPassword().equals(password)) {
                throw new BadCredentialsException("Invalid Password");
            }

            List<GrantedAuthority> roles = new ArrayList<>();

            for (Auth auth : client.getAuths()) {
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(auth.getName());
                roles.add(grantedAuthority);
            }


            return new UsernamePasswordAuthenticationToken(userName, password, roles);

        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
