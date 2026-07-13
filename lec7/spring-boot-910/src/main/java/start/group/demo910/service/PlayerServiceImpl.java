package start.group.demo910.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.group.demo910.model.Player;
import start.group.demo910.repo.PlayerRepo;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{

    private PlayerRepo playerRepo;

    @Autowired
    public PlayerServiceImpl(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepo.save(player);
    }

    @Override
    public Player modifyPlayer(Player player) {
        return  playerRepo.save(player);
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepo.findById(id).get();
    }

    @Override
    public void removePlayerById(Long id) {
        playerRepo.deleteById(id);
    }
}
