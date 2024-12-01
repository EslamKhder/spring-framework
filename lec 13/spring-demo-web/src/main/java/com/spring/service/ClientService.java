package com.spring.service;

import com.spring.model.Client;
import jakarta.transaction.SystemException;

public interface ClientService {

    Client getClientByEmail(String email) throws SystemException;
}
