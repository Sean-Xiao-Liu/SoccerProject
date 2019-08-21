//package com.xiao.soccerproject.controller;
//
//
//import com.xiao.soccerproject.model.Player;
//import com.xiao.soccerproject.model.Team;
//import com.xiao.soccerproject.service.PlayerService;
//import com.xiao.soccerproject.service.TeamService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/players")
//public class PlayerController {
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private PlayerService playerService;
//
//    @RequestMapping(value ="", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public List<Player> getPlayers(){
//        return playerService.getPlayers();
//    }
//
//    @RequestMapping(value = "/{playerName}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public Player getPlayerByName(@PathVariable String playerName){
//        return playerService.getPlayerByName(playerName);
//    }
//
//    @RequestMapping(value = "/{team}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public String createPlayer(@RequestBody Player player,@PathVariable String team){
//        String msg = "the player has been created";
//        boolean isSuccess = playerService.save(player, team);
//        if(!isSuccess) msg = "the player has not been created";
//
//        return msg;
//    }
//
//
//
//}
