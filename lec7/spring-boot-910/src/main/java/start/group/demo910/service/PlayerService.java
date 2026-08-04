package start.group.demo910.service;

import jakarta.transaction.SystemException;
import start.group.demo910.controller.vm.PlayerVM;
import start.group.demo910.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    List<PlayerDto> getPlayers();
    PlayerDto addPlayer(PlayerDto playerDto);
    PlayerDto modifyPlayer(PlayerDto playerDto);
    PlayerDto getPlayerById(Long id) throws SystemException;
    PlayerVM getPlayerId(Long id) throws SystemException;
    void removePlayerById(Long id);
}
