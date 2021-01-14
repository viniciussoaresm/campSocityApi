package br.com.campsocity.controllers;

import br.com.campsocity.pojo.Team;
import br.com.campsocity.services.TeamService;
import br.com.campsocity.services.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/team")
    public Team getPatient(@RequestParam String token) throws InterruptedException, ExecutionException {
        return teamService.get(token);
    }

    @PostMapping("/team")
    public String createPatient(@RequestBody Team team) throws InterruptedException, ExecutionException {
        team.setToken(Util.getToken());
        return teamService.save(team);
    }

    @PutMapping("/team")
    public String updatePatient(@RequestBody Team team) throws InterruptedException, ExecutionException {
        return teamService.update(team);
    }

    @DeleteMapping("/team")
    public String deletePatient(@RequestParam String token) {
        return teamService.delete(token);
    }
}