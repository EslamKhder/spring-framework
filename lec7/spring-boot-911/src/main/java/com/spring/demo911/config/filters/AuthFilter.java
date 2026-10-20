package com.spring.demo911.config.filters;

import com.spring.demo911.config.token.TokenHandler;
import com.spring.demo911.dto.AccountDto;
import com.spring.demo911.dto.RoleDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.internal.util.StringHelper;
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

    // shouldNotFilter   false     filter worked
    // shouldNotFilter   true      filter not worked
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getRequestURI().contains("auth");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = request.getHeader("Authorization");

            if (Objects.isNull(token) || !token.startsWith("Bearer")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            token = token.substring(7);
            if (token.isBlank()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            AccountDto accountDto = tokenHandler.validateToken(token);

            if (Objects.isNull(accountDto)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            // user verified
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(accountDto.getEmail(), accountDto.getPassword(), getAuthorities(accountDto.getRoles()));

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<RoleDto> roleDtos) {
        return roleDtos.stream()
                .map(roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName()))
                .collect(Collectors.toList());
    }

}
