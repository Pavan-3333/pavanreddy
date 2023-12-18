
package com.example.player.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.player.service.PlayerH2Service;
import com.example.player.model.Player;

@RestController
public class PlayerController {

    @Autowired
    private PlayerH2Service playerservice;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return playerservice.getPlayers();
    }

    @GetMapping("/players/{PlayerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId) {
        return playerservice.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerservice.addPlayer(player);
    }

    @PutMapping("/players/{PlayerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {
        return playerservice.updatePlayer(playerId, player);
    }

    @DeleteMapping("/players/{PlayerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        playerservice.deletePlayer(playerId);
    }
}
