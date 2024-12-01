package com.spring.config;


import com.spring.config.jwt.TokenHandler;
import com.spring.model.Auth;
import com.spring.model.Client;
import com.spring.service.ClientService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private ClientService clientService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        String path = request.getServletPath();
        if (path.contains("login")) {
            return true;
        }

        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (!token.startsWith("Bearer")){
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        token = token.substring(7);

        if (!tokenHandler.isValidToken(token)) {
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        Client client = clientService.checkClientExistByToken(token);

        if (Objects.isNull(client)) {
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }


        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(client, null, extractAuthority(client.getAuths()));

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);


        filterChain.doFilter(request, response);
    }

    private List<GrantedAuthority> extractAuthority (List<Auth> auths) {
        List<GrantedAuthority> roles = new ArrayList<>();

        for (Auth auth : auths) {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(auth.getName());
            roles.add(grantedAuthority);
        }

        return roles;
    }
}
