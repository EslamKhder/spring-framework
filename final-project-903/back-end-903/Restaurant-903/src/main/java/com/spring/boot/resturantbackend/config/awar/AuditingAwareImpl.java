package com.spring.boot.resturantbackend.config.awar;

import com.spring.boot.resturantbackend.dto.security.AccountDto;
import com.spring.boot.resturantbackend.models.security.Account;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditingAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentAuditor = "";
        try {
            AccountDto accountDto = (AccountDto) authentication.getPrincipal();
            currentAuditor = accountDto.getUsername();
        } catch (Exception exception) {
            currentAuditor = (String) authentication.getPrincipal();
        }
        return Optional.of(currentAuditor);
    }
}
