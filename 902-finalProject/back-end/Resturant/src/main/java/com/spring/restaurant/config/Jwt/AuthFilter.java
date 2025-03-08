package com.spring.restaurant.config.Jwt;

import com.spring.restaurant.model.clientmodels.Client;
import com.spring.restaurant.model.clientmodels.Role;
import com.spring.restaurant.service.Jwt.ClientService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private ClientService clientService;
    @Autowired
    private TokenHandler tokenHandler;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        // get  the url from the request
        String path = request.getRequestURI();
        if (path.contains("login") || path.contains("create-client")) {
            return true;
        }

        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        token = token.substring(7);
        if (!tokenHandler.validateToken(token)) {
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        try {
            Client client = clientService.checkClientExistByToken(token);
            if (client == null) {
                response.reset();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }


            //  here  we need to tell the second filter which is spring  security filter that   the user signrd in


            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(client, null, getAuthorities(client.getRoles()));


            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            filterChain.doFilter(request, response);

        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }


    // this function just to convert the clientForSpringSecurity.getAuthortiesForClients() to GrantedAuthority


    private List<GrantedAuthority> getAuthorities(List<Role> Auth) {

        List<GrantedAuthority> roles = new ArrayList<>(); //client.getAuthortiesForClients();

        for (Role role : Auth) {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getCode());
            roles.add(grantedAuthority);
        }

        return roles;
    }
}
