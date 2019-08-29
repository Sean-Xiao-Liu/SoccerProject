package com.xiao.soccerproject.controller;


import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.service.PlayerService;
import com.xiao.soccerproject.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.rmi.MarshalException;
import java.util.List;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlayerService playerService;

    //get all players//
    @RequestMapping(value = "/getPlayers",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    //get players by name method//
    @RequestMapping(value="/getPlayerByName",method = RequestMethod.GET,params = {"playerName"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Player getPlayerByName(@RequestParam(value = "playerName") String playerName){
        return playerService.getPlayerByName(playerName);
    }

    //get players by id method//
    @RequestMapping(value = "/getPlayerById/{playerId}",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})// for get request, use produce media type instead of consumes
    public Player getPlayerById(@PathVariable long playerId){
        return playerService.getPlayerById(playerId);
    }

    //save player method//
    @RequestMapping(value = "/savePlayer/{teamId}",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String createPlayer(@RequestBody Player player,@PathVariable long teamId){
        String msg = "the player has been created";
        boolean isSuccess = playerService.save(player,teamId);
        if(!isSuccess) msg = "the player has not been created";
        return msg;
    }

    //delete by player id//
    @RequestMapping(value = "/deletePlayerById/{playerId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deletePlayerById(@PathVariable long playerId){
        String msg = "the player has been deleted";
        int isSuccess = playerService.deleteById(playerId);
        if(isSuccess != 1) msg = "the player has not been deleted";
        return msg;

    }

    //delete by team name//
    @RequestMapping(value = "/deletePlayerByName",method = RequestMethod.DELETE, params = {"playerName"},produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deletePlayerByName(@RequestParam(value = "playerName")String playerName){
        String msg = "the player has been deleted";
        int isSuccess = playerService.deletePlayerByName(playerName);
        if(isSuccess != 1) msg = "the player has not been deleted";
        return msg;
    }

    //update player age//
    @RequestMapping(value = "/updatePlayerAge/{playerId}/{age}",method =RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updatePlayerAge(@PathVariable long playerId, @PathVariable int age){
        String msg = "the player age  has been updated";
        int isSuccess = playerService.updatePlayerAge(playerId,age);
        if(isSuccess != 1) msg = "the player age has not been changed";
        return msg;
    }

    @RequestMapping(value = "/updatePlayer/{teamId}",method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updatePlayer(@RequestBody Player player, @PathVariable long teamId){
        String msg = "the team info has been updated";
        int isSuccess = playerService.updatePlayer(player,teamId);
        if(isSuccess != 1) msg = "the player info has not been updated";
        return msg;
    }







}
