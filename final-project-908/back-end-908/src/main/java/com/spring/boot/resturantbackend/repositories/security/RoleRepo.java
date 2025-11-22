package com.spring.boot.resturantbackend.repositories.security;

import com.spring.boot.resturantbackend.models.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);
}
