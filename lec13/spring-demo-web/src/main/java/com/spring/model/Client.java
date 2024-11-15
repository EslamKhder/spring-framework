package com.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Client extends BaseEntity {

    private String email;

    private String password;

    private String active;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Auth> auths;
}
