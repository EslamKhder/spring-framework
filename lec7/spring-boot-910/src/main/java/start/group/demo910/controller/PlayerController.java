package start.group.demo910.controller;

import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import start.group.demo910.controller.vm.PlayerVM;
import start.group.demo910.dto.PlayerDto;
import start.group.demo910.service.PlayerService;

// http://localhost/8080/player
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDto>> getPlayers(){
        return ResponseEntity.ok(playerService.getPlayers());
    }

    @PostMapping("/player")
    public ResponseEntity<PlayerDto> addPlayer(@RequestBody @Validated PlayerDto playerDto) throws URISyntaxException {
//        return playerService.addPlayer(playerDto);
        return ResponseEntity.created(new URI("/player")).body(playerService.addPlayer(playerDto));
    }

    @PutMapping("/player")
    public ResponseEntity<PlayerDto> modifyPlayer(@RequestBody @Validated PlayerDto playerDto){
//        return playerService.modifyPlayer(playerDto);
        return ResponseEntity.ok().body(playerService.modifyPlayer(playerDto));

    }

    @GetMapping("/player")
    public ResponseEntity<PlayerDto> getPlayerById(@RequestParam(name = "playerId", required = false) Long id) throws SystemException {
//        return playerService.getPlayerById(id);
        return ResponseEntity.ok(playerService.getPlayerById(id));

    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Void> removePlayerById(@PathVariable Long id){
        playerService.removePlayerById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    TODO
        * save , update apis issue
        * getBy id get error if id not exist
        * delete api always deleted if id exist or not
        * api get player by name
        * diff between  @PathVariable and @RequestParam
     */

    @GetMapping("/player/id")
    public ResponseEntity<PlayerVM> getPlayerId(@RequestParam("playerId") Long id) throws SystemException {
        return ResponseEntity.ok(playerService.getPlayerId(id));
    }
}
