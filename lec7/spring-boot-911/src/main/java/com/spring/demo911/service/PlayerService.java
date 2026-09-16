package com.spring.demo911.service;

import com.spring.demo911.controller.vm.PlayerResponseVM;
import com.spring.demo911.dto.PlayerDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface PlayerService {

    PlayerDto savePlayer(PlayerDto playerDto) throws SystemException;

    PlayerDto updatePlayer(PlayerDto playerDto) throws SystemException;

    List<PlayerResponseVM> getAllPlayers();
    void removePlayer(Long id);

    PlayerDto getPlayerById(Long id) throws SystemException;
    PlayerDto getPlayerByName(String getPlayerName) throws SystemException;

    List<PlayerDto> searchByName(String name);
}
