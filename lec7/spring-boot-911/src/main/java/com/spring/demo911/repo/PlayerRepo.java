package com.spring.demo911.repo;

import com.spring.demo911.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {

    // nativeQuery = true   based on db
    // nativeQuery = false   based on model

//    @Query(value = "select * from Player where name = :name", nativeQuery = true)
    @Query(value = "select player from Player player where player.name = :name")
    Optional<Player> extractName(@Param("name") String name);

    Optional<List<Player>> findByNameContainingIgnoreCase(String name);




}
