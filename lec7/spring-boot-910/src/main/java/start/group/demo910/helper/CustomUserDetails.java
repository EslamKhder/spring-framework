package start.group.demo910.helper;

import jakarta.transaction.SystemException;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import start.group.demo910.dto.AccountDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    public static final String NOOP = "{noop}";
    public static final String bcrypt = "{bcrypt}";
    public static final String ROLE = "ROLE_";
    private AccountDto accountDto;

    public CustomUserDetails(AccountDto accountDto) throws SystemException {
        if (Objects.isNull(accountDto)) {
            throw new SystemException("account.null");
        }
        this.accountDto = accountDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return accountDto.getRoles().stream().map(rolesDto -> new SimpleGrantedAuthority(ROLE + rolesDto.getName())).collect(Collectors.toList());
    }

    @Override
    public @Nullable String getPassword() {
        return bcrypt + accountDto.getPassword();
    }

    @Override
    public String getUsername() {
        return accountDto.getUsername();
    }
}
