package springdemo.finalprojectrestoran.Service.Jwt;

import jakarta.transaction.SystemException;
import springdemo.finalprojectrestoran.dto.Jwt.ClientLoginDto;
import springdemo.finalprojectrestoran.dto.Jwt.TokenDto;

public interface AuthService {
    TokenDto login(ClientLoginDto clientLoginDto) throws SystemException;

}
