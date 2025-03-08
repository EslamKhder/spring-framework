package com.spring.restaurant.repository.Jwt;

import com.spring.restaurant.model.clientmodels.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findByCode(String code);

}
