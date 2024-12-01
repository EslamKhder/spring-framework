package com.spring.service.impl;

import com.spring.dao.ClientDao;
import com.spring.model.Client;
import com.spring.service.ClientService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public Client getClientByEmail(String email) throws SystemException {

        Client client = clientDao.findByEmail(email);

        if (client == null) {
            throw new SystemException("user not found");
        }

        return client;
    }
}
