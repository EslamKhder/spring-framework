package com.spring.demo911.service.impl;

import com.spring.demo911.dto.PlayerDto;
import com.spring.demo911.mapper.PlayerMapper;
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
    private PlayerMapper playerMapper;


    @Autowired
    public PlayerServiceImpl(PlayerRepo playerRepo, PlayerMapper playerMapper) {
        this.playerRepo = playerRepo;
        this.playerMapper = playerMapper;
    }

    @Override
    public PlayerDto savePlayer(PlayerDto playerDto) throws SystemException {
        if (Objects.nonNull(playerDto.getRef_num())) {
            throw new SystemException("id must be null");
        }

        Optional<Player> playerOptional = playerRepo.extractName(playerDto.getName());

        if (playerOptional.isPresent()){
            throw new SystemException("username exist with name " + playerDto.getName());
        }

        Player player = playerMapper.toEntity(playerDto);

        player = playerRepo.save(player);
        playerDto.setRef_num(player.getId());
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
        if (Objects.isNull(playerDto.getRef_num())) {
            throw new SystemException("is must be not null");
        }

        Optional<Player> playerOptional = playerRepo.findById(playerDto.getRef_num());

        if (playerOptional.isEmpty()) {
            throw new SystemException("player not found with id: " + playerDto.getRef_num());
        }

        Player player = playerMapper.toEntity(playerDto);


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
    public List<PlayerDto> getAllPlayers() {

        return playerMapper.toDtoList(playerRepo.findAll());

//        return playerRepo.findAll()
//                .stream().map(player -> playerMapper.toDto(player)).collect(Collectors.toList());
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
        return playerMapper.toDto(player);
//        return playerRepo.findById(id).orElseThrow(() -> new SystemException("Player not found with id " + id));
////        if (player.isEmpty()) {
////            throw new SystemException("Player not found with id " + id);
////        }
////        return player.get();

    }

    @Override
    public PlayerDto getPlayerByName(String name) throws SystemException {
        Player player = playerRepo.extractName(name).get();
        return playerMapper.toDto(player);
    }
    @Override
    public List<PlayerDto> searchByName(String name) {
        return playerMapper.toDtoList(playerRepo.findByNameContainingIgnoreCase(name).get());
//        return playerRepo.findByNameContainingIgnoreCase(name).get().stream().map(player -> playerMapper.toDto(player)).collect(Collectors.toList());
    }
}
