package com.xiao.soccerproject.controller;

import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/games")

public class GameController {

    @Autowired
    private GameService gameService;

    //get all games//
    /*when @JsonIgnore applied, the teamId are not available for get Games method*/
    @RequestMapping(value = "/getGames",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Game> getGames(){
        return gameService.getGames();
    }

    //get game by id//
    @RequestMapping(value = "/getGameById/{gameId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Game getGameById(@PathVariable long gameId){
        return gameService.getGameById(gameId);
    }

    //save game by id//
    @RequestMapping(value = "/saveGame/{homeTeamId}/{awayTeamId}", method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String createGame(@RequestBody Game game, @PathVariable long homeTeamId, @PathVariable long awayTeamId){
        String msg = "the Game has been created";
        boolean isSuccess = gameService.save(game,homeTeamId,awayTeamId);
        if(!isSuccess) msg = "the game has not been created";
        return msg;
    }

    //update home goals//
    @RequestMapping(value = "/updateHomeGoals/{gameId}/{homeGoals}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateHomeTeamGoals(@PathVariable long gameId, @PathVariable int homeGoals){
        String msg = "the home team goals have been updated";
        int isSuccess = gameService.updateHomeGoals(gameId,homeGoals);
        if(isSuccess != 1) msg = "the home team goals are not changed";
        return msg;
    }

    //delete by id//
    @RequestMapping(value ="/deleteGameById/{gameId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteGameById(@PathVariable long gameId){
        String msg = "The game has been deleted";
        int isSuccess = gameService.deleteById(gameId);
        if (isSuccess != 1 ) msg = "The game has not been deleted";
        return msg;
    }

    @RequestMapping(value = "/updateGame",method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateGame(@RequestBody Game game){
        String msg = "the team info has been updated";
        int isSuccess = gameService.updateGame(game);
        if(isSuccess != 1) msg = "the game info has not been updated";
        return msg;
    }

}
