package com.xiao.soccerproject.service;

import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.service.TeamService;
import com.xiao.soccerproject.service.PlayerService;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)

public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    private Team teamTestRecordOne;
    private Team teamTestRecordTwo;
    private Player playerTestRecordOne;
    private Player playerTestRecordTwo;

    @Before
    public void init() {
        // seed a record for test

        teamTestRecordOne = new Team();
        teamTestRecordOne.setTeamName("Test Team 1");
        teamTestRecordOne.setHomeWin(1);
        teamTestRecordOne.setAwayWin(1);
        teamTestRecordOne.setHomeLoss(1);
        teamTestRecordOne.setAwayLoss(1);
        teamService.save(teamTestRecordOne);

        teamTestRecordTwo = new Team();
        teamTestRecordTwo.setTeamName("Test Team 2");
        teamTestRecordTwo.setHomeWin(2);
        teamTestRecordTwo.setAwayWin(2);
        teamTestRecordTwo.setHomeLoss(2);
        teamTestRecordTwo.setAwayLoss(2);
        teamService.save(teamTestRecordTwo);

        playerTestRecordOne = new Player();
        playerTestRecordOne.setPlayerName("Test Player 1");
        playerTestRecordOne.setAge(1);
        playerTestRecordOne.setNationality("Test Country");
        playerTestRecordOne.setPlayerPosition("GK");
        playerService.save(playerTestRecordOne,teamTestRecordOne.getId());

        playerTestRecordTwo = new Player();
        playerTestRecordTwo.setPlayerName("Test Player 2");
        playerTestRecordTwo.setAge(2);
        playerTestRecordTwo.setNationality("Test Country");
        playerTestRecordTwo.setPlayerPosition("CM");
        playerService.save(playerTestRecordTwo,teamTestRecordOne.getId());

    }

    @After
    public void cleanup() {
        playerService.deleteById(playerTestRecordOne.getId());
        playerService.deleteById(playerTestRecordTwo.getId());
//        teamService.deleteById(teamTestRecordOne.getId());
        teamService.deleteTeamByName(teamTestRecordOne.getTeamName());
        teamService.deleteTeamByName(teamTestRecordTwo.getTeamName());
//        teamService.deleteById(teamTestRecordTwo.getId());
    }


    @Test
    public void getTeamsTest(){
        List<Team> teams = teamService.getTeams();
        for(Team team : teams){
            System.out.println(team);
        }
        assertEquals(2,teams.size());
    }

    @Test
    public void updateTeamByIdTest(){
        int updatedCount = teamService.updateTeamHomeWin(teamTestRecordOne.getId(),3);
        teamService.getTeamById(teamTestRecordOne.getId()).toString();
        assertEquals(1,updatedCount);
    }

    @Test
    public void getTeamByIdTest(){
        teamService.getTeamById(teamTestRecordTwo.getId());
        assertEquals(teamService.getTeamById(teamTestRecordTwo.getId()), teamTestRecordTwo);
    }


    @Test
    public void getPlayersByTeamTest(){
        Team team = teamService.getPlayersByTeamId(teamTestRecordOne.getId());
        assertEquals(2,team.getPlayers().size());
    }

    @Test
    public void getTeamByNameTest(){
        teamService.getTeamByName(teamTestRecordOne.getTeamName());
        assertEquals(teamService.getTeamByName(teamTestRecordOne.getTeamName()),teamTestRecordOne);
    }

    @Test
    public void udpateTeamTest(){
        teamTestRecordOne.setTeamName("Updated test team 1");
        int updateCount = teamService.updateTeam(teamTestRecordOne);
        assertEquals(1,updateCount);
    }

}
