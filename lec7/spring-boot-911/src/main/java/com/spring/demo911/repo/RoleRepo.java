package com.spring.demo911.repo;

import com.spring.demo911.model.Account;
import com.spring.demo911.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Long> {

}
