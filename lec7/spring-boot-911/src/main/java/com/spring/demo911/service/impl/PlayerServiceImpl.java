package com.spring.demo911.service.impl;

import com.spring.demo911.controller.vm.PlayerResponseVM;
import com.spring.demo911.dto.PlayerDto;
import com.spring.demo911.model.Player;
import com.spring.demo911.repo.PlayerRepo;
import com.spring.demo911.service.PlayerService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepo playerRepo;

    @Autowired
    public PlayerServiceImpl(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    @Override
    public PlayerDto savePlayer(PlayerDto playerDto) throws SystemException {
        if (Objects.nonNull(playerDto.getId())) {
            throw new SystemException("id must be null");
        }

        Optional<Player> playerOptional = playerRepo.extractName(playerDto.getName());

        if (playerOptional.isPresent()){
            throw new SystemException("username exist with name " + playerDto.getName());
        }

        Player player = new Player(
                playerDto.getName(),
                playerDto.getNumber(),
                playerDto.getSalary()
        );

        player = playerRepo.save(player);
        playerDto.setId(player.getId());
        return playerDto;
    }

    // update
    // case1: player {id: 1, all new}   -->
    // row name (ahmed)   case2: player {id: 1, name: already exist row ali  all any}   -->
    // row name (ahmed)   case2: player {id: 1, name: ahmed  485   65}   -->

    // 1 ahmed   1300   12
    // 2 ali      14200  35
    // 3 osama     1450   65
    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) throws SystemException {
        if (Objects.isNull(playerDto.getId())) {
            throw new SystemException("is must be not null");
        }

        Optional<Player> playerOptional = playerRepo.findById(playerDto.getId());

        if (playerOptional.isEmpty()) {
            throw new SystemException("player not found with id: " + playerDto.getId());
        }

        Player player = new Player(
                playerDto.getId(),
                playerDto.getName(),
                playerDto.getNumber(),
                playerDto.getSalary()
        );

        // row name (ahmed)   case2: player {id: 1, name: ahmed  485   65}   -->
        if (playerOptional.get().getName().equals(playerDto.getName())) {
             playerRepo.save(player);
             return playerDto;
        }

        // row name (ahmed)   case2: player {id: 1, name: already exist row ali  all any}   -->

        playerOptional = playerRepo.extractName(playerDto.getName());

        if (playerOptional.isPresent()){
            throw new SystemException("username exist with name " + playerDto.getName());
        }

        playerRepo.save(player);
        return playerDto;
    }

    @Override
    public List<PlayerResponseVM> getAllPlayers() {
        return playerRepo.findAll()
                .stream().map(player -> new PlayerResponseVM(player.getId(), player.getName())).collect(Collectors.toList());
//        long count = playerRepo.count();
//        playerDtos.stream().forEach(playerDto -> {
//            playerDto.setDetails(playerDto.getName() + " " + playerDto.getNumber());
//            playerDto.setCount(count);
//        });

//        return playerDtos;
    }

    @Override
    public void removePlayer(Long id) {
        playerRepo.deleteById(id);
    }

    @Override
    public PlayerDto getPlayerById(Long id) throws SystemException { // 1

        Player player = playerRepo.findById(id).get();
        return new PlayerDto().toDto(player);
//        return playerRepo.findById(id).orElseThrow(() -> new SystemException("Player not found with id " + id));
////        if (player.isEmpty()) {
////            throw new SystemException("Player not found with id " + id);
////        }
////        return player.get();

    }

    @Override
    public PlayerDto getPlayerByName(String name) throws SystemException {
        Player player = playerRepo.extractName(name).get();
        return new PlayerDto().toDto(player);
    }
    @Override
    public List<PlayerDto> searchByName(String name) {
        return playerRepo.findByNameContainingIgnoreCase(name).get().stream().map(player -> new PlayerDto().toDto(player)).collect(Collectors.toList());
    }

}
