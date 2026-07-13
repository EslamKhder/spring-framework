package start.group.demo910.service;

import start.group.demo910.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getPlayers();
    Player addPlayer(Player player);
    Player modifyPlayer(Player player);
    Player getPlayerById(Long id);
    void removePlayerById(Long id);
}
