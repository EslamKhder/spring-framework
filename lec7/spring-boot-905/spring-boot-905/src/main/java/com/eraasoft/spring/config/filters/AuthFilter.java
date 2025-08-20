package com.eraasoft.spring.config.filters;

import com.eraasoft.spring.dto.AccountDto;
import com.eraasoft.spring.service.token.TokenHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    private TokenHandler tokenHandler;

    public AuthFilter(TokenHandler tokenHandler) {
        this.tokenHandler = tokenHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        
        if (Objects.isNull(token) || !token.startsWith("Bearer")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 01234567
        // Bearer dskjdslfjlsjsdlfdk
        token = token.substring(7);
        AccountDto accountDto = tokenHandler.validateToken(token);

        if (Objects.isNull(accountDto)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }


        List<SimpleGrantedAuthority> roles = getAuthorities(accountDto);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(accountDto, accountDto.getPassword(), roles);


        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);
    }

    private List<SimpleGrantedAuthority> getAuthorities(AccountDto accountDto) {
        return accountDto.getRoles().stream().map(roleDto ->
                new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName())).collect(Collectors.toList());
    }


    // shouldNotFilter    false       filter     all apis    ---     (sign_up, login)
    // shouldNotFilter    true        not filter (sign_up, login)
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup")){
            return true;
        }

        return false;
    }
}
