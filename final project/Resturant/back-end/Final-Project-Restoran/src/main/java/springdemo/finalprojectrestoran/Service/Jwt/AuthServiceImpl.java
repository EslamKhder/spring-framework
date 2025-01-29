package springdemo.finalprojectrestoran.Service.Jwt;

import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springdemo.finalprojectrestoran.Config.Jwt.TokenHandler;
import springdemo.finalprojectrestoran.dto.Jwt.ClientLoginDto;
import springdemo.finalprojectrestoran.dto.Jwt.TokenDto;
import springdemo.finalprojectrestoran.model.ClientModels.Client;

@Service
public class AuthServiceImpl implements AuthService {
   @Autowired
    private ClientService clientService;

   @Autowired
    private TokenHandler tokenHandler;

   @Autowired
   private PasswordEncoder passwordEncoder;

    @Override
    public TokenDto login(ClientLoginDto clientLoginDto) throws SystemException {
        Client client = clientService.getClientbyEmail(clientLoginDto.getEmail());

        if (!passwordEncoder.matches(clientLoginDto.getPassword(),client.getPassword())) {
            throw new BadCredentialsException("error.clientNotExist");
        }
        return new TokenDto(tokenHandler.createToken(client));
    }
}
