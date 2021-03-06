package com.xiao.soccerproject.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "teams") // cacheable teams, redis
    @RequestMapping(value= "/getTeams", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @JsonView(Team.TeamInfo.class)
    public List<Team> getTeams(){
        return teamService.getTeams();
    }

    //getTeamByName method//
    @RequestMapping(value="/getTeamByName",method = RequestMethod.GET, params = {"teamName"},produces = {MediaType.APPLICATION_JSON_VALUE})
    //use pass param to distinguish different //
    @JsonView(Team.TeamInfo.class)
    public Team getTeamByName(@RequestParam(value = "teamName") String teamName){
        Team team = teamService.getTeamByName(teamName);
        return team;
    }

    //getTeamById method//
    @RequestMapping(value = "/getTeamById/{teamId}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
//    @RequestMapping(value = "",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @JsonView(Team.TeamInfo.class)
    public Team getTeamById(@PathVariable long teamId){ // to solve the ambiguous handler methods mapping problem
        Team team = teamService.getTeamById(teamId);
        return team;
    }

    //saveTeam method//
    @CachePut(value = "teams", key = "#team.id", unless = "#team.teamName == null")
    @RequestMapping(value = "/saveTeam", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String createTeam(@RequestBody Team team){
        String msg = "the team has been created";
        boolean isSuccess = teamService.save(team);
        if(!isSuccess) msg = "the team has not been created";
        return msg;
    }

    //deleteById//
    @RequestMapping(value = "/deleteTeamById/{teamId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteTeamById(@PathVariable long teamId){
        String msg = "the team has been deleted";
        int isSuccess = teamService.deleteById(teamId);
        if(isSuccess != 1) msg = "the team has not been deleted";
        return msg;
    }

    //deleteByName//
    @RequestMapping(value = "/deleteTeamByName",method = RequestMethod.DELETE, params = {"teamName"},produces = {MediaType.APPLICATION_JSON_VALUE})
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
    @RequestMapping(value = "/getPlayersByTeamId",method = RequestMethod.GET, params = {"teamId"},produces = {MediaType.APPLICATION_JSON_VALUE})
    //use pass param to distinguish different //
    @JsonView(Team.PlayerInfo.class)
    public Team getPlayersByTeamId(@RequestParam(value = "teamId") long teamId){
        Team players = teamService.getPlayersByTeamId(teamId);
        return players;
    }

    //update Team//
    @RequestMapping(value = "/updateTeam",method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateTeam(@RequestBody Team team){
        String msg = "the team info has been updated";
        int isSuccess = teamService.updateTeam(team);
        if(isSuccess != 1) msg = "the team info has not been updated";
        return msg;
    }
}
