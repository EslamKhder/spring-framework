package com.spring.boot.config.filter;

import com.spring.boot.config.jwt.TokenHandler;
import com.spring.boot.dto.StudentDto;
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
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private TokenHandler tokenHandler;


    // shouldNotFilter   false       filter work
    // shouldNotFilter   true       filter not work
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        boolean authResult = request.getRequestURI().contains("login") ||
                request.getRequestURI().contains("signup");

        return authResult;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        // Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlc2xhbS5raGRlciIsImlhdCI6MTc2MDYzODczOCwiZXhwIjoxNzYwNzI1MTM4LCJuYW1lIjoiZXNsYW0iLCJyb2xlcyI6WyJVU0VSIl19.B9zU9nQHW_6J-LhZdUbwsuh0c8U57_5mYqK1LPO5WTo

        if (Objects.isNull(token) || !token.startsWith("Bearer")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlc2xhbS5raGRlciIsImlhdCI6MTc2MDYzODczOCwiZXhwIjoxNzYwNzI1MTM4LCJuYW1lIjoiZXNsYW0iLCJyb2xlcyI6WyJVU0VSIl19.B9zU9nQHW_6J-LhZdUbwsuh0c8U57_5mYqK1LPO5WTo
        token = token.substring(7);

        StudentDto studentDto = tokenHandler.validateToken(token);
        if (Objects.isNull(studentDto)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // token valid can process to api
        List<GrantedAuthority> roles =  studentDto.getRoles().stream().map(
                roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getName())
        ).collect(Collectors.toList());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(studentDto, studentDto.getPassword(), roles);

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request, response);
    }
}
