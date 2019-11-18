package com.xiao.soccerproject.repository;

import static org.junit.Assert.*;

import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.model.Game;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)

public class TeamDAOImplTest {

@Autowired
private TeamDAO teamDAOImpl;
private Team teamTestRecordOne;
private Team teamTestRecordTwo;
private Team teamTestRecordThree;

@Autowired
private PlayerDAO playerDAOImpl;
private Player playerTestRecordOne;
private Player playerTestRecordTwo;

@Autowired
private GameDAO gameDAOImpl;
private Game gameTestRecordOne;



    @Before
    public void init(){

        teamTestRecordOne = new Team();
        teamTestRecordOne.setTeamName("Test Team 1");
        teamTestRecordOne.setHomeWin(1);
        teamTestRecordOne.setAwayWin(1);
        teamTestRecordOne.setHomeLoss(1);
        teamTestRecordOne.setAwayLoss(1);
        teamDAOImpl.save(teamTestRecordOne);

        teamTestRecordTwo = new Team();
        teamTestRecordTwo.setTeamName("Test Team 2");
        teamTestRecordTwo.setHomeWin(2);
        teamTestRecordTwo.setAwayWin(2);
        teamTestRecordTwo.setHomeLoss(2);
        teamTestRecordTwo.setAwayLoss(2);
        teamDAOImpl.save(teamTestRecordTwo);

        playerTestRecordOne = new Player();
        playerTestRecordOne.setPlayerName("Test Player 1");
        playerTestRecordOne.setAge(1);
        playerTestRecordOne.setNationality("Test Country");
        playerTestRecordOne.setPlayerPosition("GK");
        playerDAOImpl.save(playerTestRecordOne,teamTestRecordOne.getId());

        playerTestRecordTwo = new Player();
        playerTestRecordTwo.setPlayerName("Test Player 2");
        playerTestRecordTwo.setAge(2);
        playerTestRecordTwo.setNationality("Test Country");
        playerTestRecordTwo.setPlayerPosition("CM");
        playerDAOImpl.save(playerTestRecordTwo,teamTestRecordOne.getId());

    }

    @After
    public void cleanup(){
        playerDAOImpl.deleteById(playerTestRecordOne.getId()); // needs to delete players first or it will violate the players_teams_fk
        playerDAOImpl.deleteById(playerTestRecordTwo.getId());
        teamDAOImpl.deleteTeamByName(teamTestRecordOne.getTeamName());
        teamDAOImpl.deleteTeamByName(teamTestRecordTwo.getTeamName());

        teamDAOImpl = null;
        playerDAOImpl=null;
        gameDAOImpl=null;

    }


    @Test
    public void getTeamsTest(){
        List<Team> teams = teamDAOImpl.getTeams();
        for(Team team : teams){
            System.out.println(team);
        }

    }

    @Test
    public void updateTeamByIdTest(){
        int updatedCount = teamDAOImpl.updateTeamHomeWin(teamTestRecordOne.getId(),3);
        teamDAOImpl.getTeamById(teamTestRecordOne.getId()).toString();
        assertEquals(1,updatedCount);
    }


    @Test
    public void getTeamByIdTest(){
        teamDAOImpl.getTeamById(teamTestRecordTwo.getId());
//        assertNotNull(teamDAOImpl.getTeamById(teamTestRecordTwo.getId()));
        assertEquals(teamDAOImpl.getTeamById(teamTestRecordTwo.getId()),teamTestRecordTwo);
    }

    @Test
    public void getPlayersByTeamTest(){
        Team team = teamDAOImpl.getPlayersByTeamId(teamTestRecordOne.getId());
        assertEquals(2,team.getPlayers().size());
    }

    @Test
    public void getTeamByNameTest(){
        teamDAOImpl.getTeamByName(teamTestRecordOne.getTeamName());
//        assertNotNull(teamDAOImpl.getTeamByName(teamTestRecordOne.getTeamName()));
        assertEquals(teamDAOImpl.getTeamByName(teamTestRecordOne.getTeamName()),teamTestRecordOne);
    }

    @Test
    public void deleteTeamByNameTest(){
        teamTestRecordThree = new Team();
        teamTestRecordThree.setTeamName("Test Team 3");
        teamTestRecordThree.setHomeWin(3);
        teamTestRecordThree.setAwayWin(3);
        teamTestRecordThree.setHomeLoss(3);
        teamTestRecordThree.setAwayLoss(3);
        teamDAOImpl.save(teamTestRecordThree);

        int deleteCount = teamDAOImpl.deleteTeamByName(teamTestRecordThree.getTeamName());
        assertEquals(1,deleteCount);

    }


}
