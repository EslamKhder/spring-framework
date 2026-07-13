package start.group.demo910.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import start.group.demo910.model.Player;
import start.group.demo910.service.PlayerService;

// http://localhost/8080/player
import java.util.List;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @PostMapping("/player")
    public Player addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }

    @PutMapping("/player")
    public Player modifyPlayer(@RequestBody Player player){
        return playerService.modifyPlayer(player);
    }

    @GetMapping("/player")
    public Player getPlayerById(@RequestParam("playerId") Long id){
        return playerService.getPlayerById(id);
    }

    @DeleteMapping("/player/{id}")
    public void removePlayerById(@PathVariable Long id){
        playerService.removePlayerById(id);
    }

    /*
    TODO
        * save , update apis issue
        * getBy id get error if id not exist
        * delete api always deleted if id exist or not
        * api get player by name
        * diff between  @PathVariable and @RequestParam
     */
}
