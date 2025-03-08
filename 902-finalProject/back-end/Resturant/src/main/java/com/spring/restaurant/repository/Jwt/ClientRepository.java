package com.spring.restaurant.repository.Jwt;

import com.spring.restaurant.model.clientmodels.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

    Client findByEmail(String email);

}
