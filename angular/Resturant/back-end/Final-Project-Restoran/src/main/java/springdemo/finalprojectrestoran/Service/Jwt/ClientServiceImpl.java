package springdemo.finalprojectrestoran.Service.Jwt;

import jakarta.transaction.SystemException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springdemo.finalprojectrestoran.Config.Jwt.TokenHandler;
import springdemo.finalprojectrestoran.Mapper.ClientMapper;
import springdemo.finalprojectrestoran.Mapper.RoleMapper;
import springdemo.finalprojectrestoran.Repository.Jwt.ClientRepository;
import springdemo.finalprojectrestoran.Repository.Jwt.RoleRepository;
import springdemo.finalprojectrestoran.dto.Jwt.ClientDto;
import springdemo.finalprojectrestoran.dto.Jwt.RoleDto;
import springdemo.finalprojectrestoran.model.ClientModels.Client;
import springdemo.finalprojectrestoran.model.ClientModels.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Client getClientbyEmail(String email) throws SystemException {

        Client client = clientRepository.findByEmail(email);


        if (client == null) {

            throw new RuntimeException("error.invalid.email");
        }

        return client;
    }

    @Override
    public Client checkClientExistByToken(String token) {
        String email = tokenHandler.getSubject(token);

        if (Objects.isNull(email)) {
            return null;
        }

        return clientRepository.findByEmail(email);
    }

    @Override
    public void createUserClient(ClientDto clientDto) throws SystemException {

        if (clientDto.getId() != null) {
            throw new SystemException("id must be null");
        }
        Client clientExits = clientRepository.findByEmail(clientDto.getEmail());
        if (clientExits != null) {
            throw new RuntimeException("error.clientExist");
        }

        Client client = ClientMapper.Client_Mapper.toEntity(clientDto);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        Role role = roleRepository.findByCode("ROLE_USER");
        if (role == null) {
            throw new SystemException("role not exist");
        }
        List<Role> roles = List.of(role);
        client.setRoles(roles);
        clientRepository.save(client);
    }


    @Override
    public ClientDto getClientById(Long id) {
       Client clients = clientRepository.findById(id).get();
      return ClientMapper.Client_Mapper.toDto(clients);
    }


}
