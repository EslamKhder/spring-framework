package com.spring.demo911.controller;

import com.spring.demo911.controller.vm.PlayerResponseVM;
import com.spring.demo911.dto.PlayerDto;
import com.spring.demo911.service.PlayerService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<PlayerResponseVM> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @PostMapping("/players")
    public PlayerDto addPlayer(@RequestBody @Validated PlayerDto playerDto) throws SystemException {
        return playerService.savePlayer(playerDto);
    }

    @PutMapping("/players")
    public PlayerDto updatePlayer(@RequestBody PlayerDto playerDto) throws SystemException {
        return playerService.updatePlayer(playerDto);
    }

    // /players?id=1
    // /players/1
//    @DeleteMapping("/players")
//    public void deletePayer(@RequestParam Long id){
//        playerService.removePlayer(id);
//    }

    @DeleteMapping("/players/{id}")
    public void deletePayer(@PathVariable Long id){
        playerService.removePlayer(id);
    }

    @GetMapping("/players/{id}")
    public PlayerDto getPlayer(@PathVariable Long id) throws SystemException {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/players/name/{name}")
    public PlayerDto getPlayerName(@PathVariable String name) throws SystemException {
        return playerService.getPlayerByName(name);
    }
    @GetMapping("/players/search/{name}")
    public List<PlayerDto> searchByName(@PathVariable String name) throws SystemException {
        return playerService.searchByName(name);
    }

}