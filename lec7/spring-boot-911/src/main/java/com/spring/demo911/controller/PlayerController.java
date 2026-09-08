package com.spring.demo911.controller;

import com.spring.demo911.model.Player;
import com.spring.demo911.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RestController
@RequestMapping("/player")
public class PlayerController {


    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("player", new Player());
        return "player-form";
    }

    @PostMapping("/save")
    public String savePlayer(@ModelAttribute("player") Player player) {
        playerService.savePlayer(player);
        return "player-form";
    }

}
