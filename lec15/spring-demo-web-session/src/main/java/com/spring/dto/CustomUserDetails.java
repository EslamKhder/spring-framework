package com.spring.dto;

import com.spring.model.Auth;
import com.spring.model.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails /*implements UserDetails*/ {

/*
    private Client client;

    public CustomUserDetails(Client client) {
        this.client = client;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();

        for (Auth auth : client.getAuths()) {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(auth.getName());
            roles.add(grantedAuthority);
        }

        return roles;
    }

    @Override
    public String getPassword() {
        return "{noop}" + client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getEmail();
    }*/



}
