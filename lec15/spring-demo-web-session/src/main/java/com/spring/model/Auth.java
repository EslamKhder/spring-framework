package com.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Auth extends BaseEntity{


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
