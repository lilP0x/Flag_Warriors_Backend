
package edu.eci.arsw.project.flagwarriors.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.eci.arsw.project.flagwarriors.service.PlayerService;
import edu.eci.arsw.project.flagwarriors.service.TeamService;


@RestController
@RequestMapping("/api/game")
public class GameControllers {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/lobby", method = RequestMethod.GET)
    public String iniciarJuego(){
        return "lobby";
    }
    @GetMapping("/game")
    public String game() {
        return "game"; 
    }
    @GetMapping("/final")
    public String getFinal() {
        return "final"; 
    }

    @GetMapping("/error")
    public String error() {
        return "error"; 
    }
    @DeleteMapping
    public void delete(){
        teamService.delete();
        playerService.delete();

    }
   
}

