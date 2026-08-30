package start.group.demo910.service.security;

import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import start.group.demo910.dto.AccountDto;
import start.group.demo910.helper.CustomUserDetails;
import start.group.demo910.service.AccountService;

//@Service
public class CustomUserDetailsService implements UserDetailsService {


    private AccountService accountService;

    @Autowired
    public CustomUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            AccountDto accountDto = accountService.getAccountByUser(username);

            return new CustomUserDetails(accountDto);
        } catch (SystemException e) {
            System.out.println("error: " + e.getMessage());
        }

        return null;
    }
}
