package com.spring.demo.config.filters;

import com.spring.demo.dto.AccountDto;
import com.spring.demo.model.Role;
import com.spring.demo.service.token.JwtTokenHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenHandler jwtTokenHandler;

    private final String ROLE = "ROLE_";

    // true
    // false

    // not filter    true
    // not filter    false
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        if (request.getRequestURI().contains("login") || request.getRequestURI().contains("signup") ) {
            return true;
        }

        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (Objects.isNull(token) || !token.startsWith("Bearer")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // Bearer asjshdkjsad
        token = token.substring(7); // token

        AccountDto accountDto = jwtTokenHandler.validateToken(token);

        if (Objects.isNull(accountDto)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // user verified

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(accountDto.getUserName(), accountDto.getPassword(), getAuthorities(accountDto.getRoles()));

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request, response);
    }

    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {

        return roles.stream().map(role -> new SimpleGrantedAuthority(ROLE + role.getRole())).collect(Collectors.toList());
    }
}
