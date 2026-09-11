package start.group.demo910.service.provider;

import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import start.group.demo910.dto.AccountDto;
import start.group.demo910.dto.RolesDto;
import start.group.demo910.model.Account;
import start.group.demo910.service.AccountService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//@Component
public class CustomAuthProvider implements AuthenticationProvider {

    private AccountService accountService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthProvider(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        try {
            AccountDto accountDto = accountService.getAccountByUser(userName);
            boolean isPasswordNotMatchV1 = !passwordEncoder.matches(password, accountDto.getPassword());
            boolean isPasswordNotMatchV2 = !password.equals(accountDto.getPassword());
            if (isPasswordNotMatchV1 && isPasswordNotMatchV2) {
                return null;
            }
//            if (!passwordEncoder.matches(password, accountDto.getPassword())){
//                return null;
//            }
//            if (!password.equals(accountDto.getPassword())) {
//                return null;
//            }
            // same userName and password
            return new UsernamePasswordAuthenticationToken(userName, password, getAuthorities(accountDto.getRoles()));
        } catch (SystemException e) {
            System.out.println("Exe: " + e.toString());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public List<SimpleGrantedAuthority> getAuthorities(List<RolesDto> rolesDtos) {
        return rolesDtos.stream().map(rolesDto -> new SimpleGrantedAuthority("ROLE_" + rolesDto.getName())).collect(Collectors.toList());
    }
}
