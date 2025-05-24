package com.spring.boot.config.filters;

import com.spring.boot.config.SecurityConfig;
import com.spring.boot.config.TokenHandler;
import com.spring.boot.dto.EmployeeDto;
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
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private TokenHandler tokenHandler;

    // shouldNotFilter   true     false
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return checkPath(request.getRequestURI(), SecurityConfig.PUBLIC_APIS);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (Objects.isNull(token) || !token.startsWith("Bearer")) {
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        token = token.substring(7);

        EmployeeDto employeeDto = tokenHandler.validateToken(token);
        if (Objects.isNull(employeeDto)) {
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        List<GrantedAuthority> roles = employeeDto.getRoleDtos().stream().map(roleDto ->
                new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName())).collect(Collectors.toList());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(employeeDto, employeeDto.getPassword(), roles);

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);
    }

    // /auth/signup                                  // finalPath =  /auth/**
    // /auth/login                                  // finalPath =  /auth/**
    // /swagger-ui/index.html                       // finalPath =  /swagger-ui/**
    // /v3/api-docs                               // finalPath =    /v3/**
    private boolean checkPath(String originalPath, String [] publicPaths) {
        String[] parts = originalPath.split("/"); // ["", "v3", "api-docs"]
        String finalPath = "/" + parts[1] + "/**";

        return Arrays.asList(publicPaths).contains(finalPath);
    }
}
