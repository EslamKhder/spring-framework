package com.boot.start.helpers;

import com.boot.start.model.Employee;
import com.boot.start.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private Employee employee;

    public CustomUserDetails(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();

        List<Role> roles = employee.getRoles();

        for (int i=0;i<roles.size();i++) {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + roles.get(i).getRoleName());
            simpleGrantedAuthorities.add(grantedAuthority);
        }

        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return "{noop}" + employee.getPassword();
    }

    @Override
    public String getUsername() {
        return  employee.getName();
    }
}
