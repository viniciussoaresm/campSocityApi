package br.com.campsocity.controllers;

import br.com.campsocity.pojo.Player;
import br.com.campsocity.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/player")
    public Player getPatient(@RequestParam String document) throws InterruptedException, ExecutionException{
        return playerService.get(document);
    }

    @PostMapping("/player")
    public String createPatient(@RequestBody Player player) throws InterruptedException, ExecutionException {
        return playerService.save(player);
    }

    @PutMapping("/player")
    public String updatePatient(@RequestBody Player player) throws InterruptedException, ExecutionException {
        return playerService.update(player);
    }

    @DeleteMapping("/player")
    public String deletePatient(@RequestParam String document){
        return playerService.delete(document);
    }
}