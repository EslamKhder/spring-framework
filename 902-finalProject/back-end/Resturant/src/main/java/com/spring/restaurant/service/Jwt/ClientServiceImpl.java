package com.spring.restaurant.service.Jwt;

import com.spring.restaurant.config.Jwt.TokenHandler;
import com.spring.restaurant.mapper.ClientMapper;
import com.spring.restaurant.model.clientmodels.Client;
import com.spring.restaurant.model.clientmodels.Role;
import com.spring.restaurant.repository.Jwt.ClientRepository;
import com.spring.restaurant.repository.Jwt.RoleRepository;
import com.spring.restaurant.service.dto.Jwt.ClientDto;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
