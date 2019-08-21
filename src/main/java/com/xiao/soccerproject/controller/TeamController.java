package com.xiao.soccerproject.controller;

import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/teams")
public class TeamController {
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TeamService teamService;

    @RequestMapping(value ="", method = RequestMethod.GET, produces = "application/json")
    public List<Team> getTeams(){
        return teamService.getTeams();
    }
}
