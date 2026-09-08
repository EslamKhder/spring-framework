package com.spring.demo911.service;

import com.spring.demo911.model.Player;

import java.util.List;

public interface PlayerService {

    void savePlayer(Player player);

    List<Player> getAllPlayers();
}
