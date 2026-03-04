package com.spring.boot.resturantbackend.config.audit;

import com.spring.boot.resturantbackend.dto.security.AccountDto;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            AccountDto accountDto = (AccountDto)authentication.getPrincipal();
            return Optional.of(accountDto.getUsername());
        } catch (Exception exception) {
            return Optional.of(authentication.getPrincipal().toString());
        }

    }
}