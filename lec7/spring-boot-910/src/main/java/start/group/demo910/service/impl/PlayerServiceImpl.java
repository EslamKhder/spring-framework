package start.group.demo910.service.impl;

import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.group.demo910.controller.vm.PlayerVM;
import start.group.demo910.dto.PlayerDto;
import start.group.demo910.mapper.PlayerMapper;
import start.group.demo910.model.Player;
import start.group.demo910.repo.PlayerRepo;
import start.group.demo910.service.PlayerService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepo playerRepo;

    private PlayerMapper playerMapper;

    //private ModelMapper modelMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepo playerRepo, PlayerMapper playerMapper/*, ModelMapper modelMapper*/) {
        this.playerRepo = playerRepo;
        this.playerMapper = playerMapper;
        //this.modelMapper = modelMapper;
    }

    @Override
    public List<PlayerDto> getPlayers() {
        return playerMapper.toDtoList(playerRepo.findAll());

//        return playerRepo.findAll().stream()
//                .map(player -> modelMapper.map(player, PlayerDto.class))
////                .map(player -> new PlayerDto(player.getId(), player.getName(), player.getNumber(), player.getSalary()))
//                .collect(Collectors.toList());
    }

    @Override
    public PlayerDto addPlayer(PlayerDto playerDto) {
        Player player = playerMapper.toEntity(playerDto);
        //Player player = new Player(playerDto.getName(), playerDto.getNumber(), playerDto.getSalary());
        player =  playerRepo.save(player);

        playerDto.setId(player.getId());
        return playerDto;
    }

    @Override
    public PlayerDto modifyPlayer(PlayerDto playerDto) {
        Player player = playerMapper.toEntity(playerDto);
        //Player player = new Player(playerDto.getId(), playerDto.getName(), playerDto.getNumber(), playerDto.getSalary());
        playerRepo.save(player);
        return playerDto;
    }

    @Override
    public PlayerDto getPlayerById(Long id) throws SystemException {
        if (Objects.isNull(id)) {
            throw new SystemException("invalid id");
        }
        Optional<Player> optionalPlayer = playerRepo.findById(id);

        if (optionalPlayer.isEmpty()) {
            throw new SystemException("player.notExist");
        }

        Player player = optionalPlayer.get();
        PlayerDto playerDto = playerMapper.toDto(player);
        playerDto.setCount(playerRepo.count());
        return playerDto;
//        Player player = optionalPlayer.get();

//
//        player.setCount(Math.toIntExact(count));
//        player.setFullName(player.getName() + " - " + player.getNumber());
        //return optionalPlayer.get();
    }

    @Override
    public PlayerVM getPlayerId(Long id) throws SystemException {
        Optional<Player> optionalPlayer = playerRepo.findById(id);

        if (optionalPlayer.isEmpty()) {
            throw new SystemException("player not exist with id: " + id);
        }

        Player player = optionalPlayer.get();
        return playerMapper.toVM(player);
    }

    @Override
    public void removePlayerById(Long id) {
        playerRepo.deleteById(id);
    }
}
