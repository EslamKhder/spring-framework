package springdemo.finalprojectrestoran.Service.Jwt;

import jakarta.transaction.SystemException;
import springdemo.finalprojectrestoran.dto.Jwt.ClientDto;
import springdemo.finalprojectrestoran.model.ClientModels.Client;

import java.util.List;

public interface ClientService {

    Client getClientbyEmail(String email) throws SystemException;
    Client checkClientExistByToken(String token) throws SystemException;
    void createUserClient (ClientDto clientDto) throws SystemException;
    ClientDto getClientById( Long id);
}
