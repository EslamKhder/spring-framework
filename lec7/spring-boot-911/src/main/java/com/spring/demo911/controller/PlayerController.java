package com.spring.demo911.controller;

import com.spring.demo911.dto.PlayerDto;
import com.spring.demo911.service.PlayerService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDto>> getAllPlayers(){
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @PostMapping("/players")
    public ResponseEntity<PlayerDto> addPlayer(@RequestBody @Validated PlayerDto playerDto) throws SystemException, URISyntaxException {
        return ResponseEntity.created(new URI("/players")).body(playerService.savePlayer(playerDto));
    }

    @PutMapping("/players")
    public ResponseEntity<PlayerDto> updatePlayer(@RequestBody PlayerDto playerDto) throws SystemException {
        return ResponseEntity.ok(playerService.updatePlayer(playerDto));
    }

    // /players?id=1
    // /players/1
//    @DeleteMapping("/players")
//    public void deletePayer(@RequestParam Long id){
//        playerService.removePlayer(id);
//    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<Void> deletePayer(@PathVariable Long id){
        playerService.removePlayer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<PlayerDto> getPlayer(@PathVariable Long id) throws SystemException {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @GetMapping("/players/name/{name}")
    public ResponseEntity<PlayerDto> getPlayerName(@PathVariable String name) throws SystemException {
        return ResponseEntity.ok(playerService.getPlayerByName(name));
    }

    @GetMapping("/players/search/{name}")
    public ResponseEntity<List<PlayerDto>> searchByName(@PathVariable String name) throws SystemException {
        return ResponseEntity.ok(playerService.searchByName(name));
    }

}