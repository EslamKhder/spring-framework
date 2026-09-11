package start.group.demo910.config.filters;

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
import start.group.demo910.dto.AccountDto;
import start.group.demo910.dto.RolesDto;
import start.group.demo910.service.token.TokenHandler;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private TokenHandler tokenHandler;

    // notfilter   true      not worked
    // notfilter   false      worked

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

            AccountDto accountDto = tokenHandler.validateToken(token);
            if (Objects.isNull(accountDto)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(accountDto.getUsername(), accountDto.getPassword(), getAuthorities(accountDto.getRoles()));

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            filterChain.doFilter(request, response);

        } catch (Exception exception) {
            System.out.println("ex: " + exception.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }


    }


    public List<SimpleGrantedAuthority> getAuthorities(List<RolesDto> rolesDtos) {
        return rolesDtos.stream().map(rolesDto -> new SimpleGrantedAuthority("ROLE_" + rolesDto.getName())).collect(Collectors.toList());
    }
}
