package com.xiao.soccerproject.controller;

import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;


@RestController
@RequestMapping(value = "/teams")
public class TeamController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TeamService teamService;

    //getTeams method//
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Team> getTeams(){
        return teamService.getTeams();
    }

    //getTeamByName method//
    @RequestMapping(method = RequestMethod.GET, params = {"teamName"},produces = {MediaType.APPLICATION_JSON_VALUE})
    //use pass param to distinguish different //
    public Team getTeamByName(@RequestParam(value = "teamName") String teamName){
        Team team = teamService.getTeamByName(teamName);
        return team;
    }

    //getTeamById method//
    @RequestMapping(value = "/{teamId}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
//    @RequestMapping(value = "",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Team getTeamById(@PathVariable long teamId){ // to solve the ambiguous handler methods mapping problem
        Team team = teamService.getTeamById(teamId);
        return team;
    }

    //saveTeam method//
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String createTeam(@RequestBody Team team){
        String msg = "the team has been created";
        boolean isSuccess = teamService.save(team);
        if(!isSuccess) msg = "the team has not been created";
        return msg;
    }

    //deleteById//
    @RequestMapping(value = "/{teamId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteTeamById(@PathVariable long teamId){
        String msg = "the team has been deleted";
        int isSuccess = teamService.deleteById(teamId);
        if(isSuccess != 1) msg = "the team has not been deleted";
        return msg;
    }

    //deleteByName//
    @RequestMapping(method = RequestMethod.DELETE, params = {"teamName"},produces = {MediaType.APPLICATION_JSON_VALUE})
    //use pass param to distinguish different //
    public String deleteTeamByName(@RequestParam(value = "teamName") String teamName){
        String msg = "the team has been deleted";
        int isSuccess = teamService.deleteTeamByName(teamName);
        if(isSuccess != 1) msg = "the team has not been deleted";
        return msg;
    }

    //updateTeamHomeWin//
    @RequestMapping(value = "/{teamId}/{homeWin}", method = RequestMethod.PUT,produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateTeamHomeWin(@PathVariable long teamId, @PathVariable int homeWin){
        String msg = "the team win has been updated";
        int isSuccess = teamService.updateTeamHomeWin(teamId,homeWin);
        if(isSuccess != 1) msg = "the team win has not been updated";
        return msg;
    }

    //getPlayersByTeamId//
    @RequestMapping(method = RequestMethod.GET, params = {"teamId"},produces = {MediaType.APPLICATION_JSON_VALUE})
    //use pass param to distinguish different //
    public List<Player> getPlayersByTeamId(@RequestParam(value = "teamId") long teamId){
        List<Player> players = teamService.getPlayersByTeamId(teamId);
        return players;
    }

    //update Team//
    @RequestMapping(method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateTeam(@RequestBody Team team){
        String msg = "the team info has been updated";
        int isSuccess = teamService.updateTeam(team);
        if(isSuccess != 1) msg = "the team info has not been updated";
        return msg;
    }
}
