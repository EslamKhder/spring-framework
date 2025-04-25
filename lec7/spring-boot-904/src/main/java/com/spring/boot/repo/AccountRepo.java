package com.spring.boot.repo;

import com.spring.boot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    List<Account> findByName(String name);

    // native query
    // none native query
    @Query(value = "SELECT * from Account where name like %:name%", nativeQuery = true)
    List<Account> search(@Param("name") String name);
}
