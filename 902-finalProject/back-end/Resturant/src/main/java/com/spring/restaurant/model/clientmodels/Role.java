package com.spring.restaurant.model.clientmodels;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Role extends ClientBaseEntity {


    private String code;

    @ManyToMany(mappedBy = "roles")
    private List<Client> client;
}
