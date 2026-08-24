package start.group.demo910.helper;

import jakarta.transaction.SystemException;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import start.group.demo910.dto.AccountDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class CustomUserDetails implements UserDetails {

    private AccountDto accountDto;

    public CustomUserDetails(AccountDto accountDto) throws SystemException {
        if (Objects.isNull(accountDto)) {
            throw new SystemException("account.null");
        }
        this.accountDto = accountDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public @Nullable String getPassword() {
        return accountDto.getPassword();
    }

    @Override
    public String getUsername() {
        return accountDto.getUsername();
    }
}
