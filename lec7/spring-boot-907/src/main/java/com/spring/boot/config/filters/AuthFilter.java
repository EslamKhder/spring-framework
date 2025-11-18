package com.spring.boot.config.filters;

import com.spring.boot.config.TokenHandler;
import com.spring.boot.dto.TeacherDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.SystemException;
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
    private TokenHandler tokenHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String token = request.getHeader("Authorization");// Bearer adssdasads

            if (Objects.isNull(token) || !token.startsWith("Bearer ")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            token = token.substring(7); // adssdasads

            TeacherDto teacherDto = tokenHandler.validateToken(token);

            if (Objects.isNull(teacherDto)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            List<SimpleGrantedAuthority> roles = teacherDto.getRoles().stream()
                    .map(roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getCode())).collect(Collectors.toList());


            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(teacherDto, teacherDto.getPassword(), roles);

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            filterChain.doFilter(request, response);

        } catch (SystemException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
    }

    // shouldNotFilter    true  --->    no     (login, signup)
    // shouldNotFilter    false --->    yes    (......)
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String uri = request.getRequestURI();
        return uri.contains("login") || uri.contains("signup");
    }
}
