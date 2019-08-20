package com.xiao.soccerproject.repository;

import static org.junit.Assert.*;

import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.model.Game;
import org.junit.*;


import javax.transaction.Transactional;
import java.util.List;

public class TeamDAOImplTest {
private TeamDAOImpl teamDAOImpl;
private Team teamTestRecordOne;
private Team teamTestRecordTwo;
private Team teamTestRecordThree;
private PlayerDAOImpl playerDAOImpl;
private Player playerTestRecordOne;
private Player playerTestRecordTwo;
private GameDAOImpl gameDAOImpl;
private Game gameTestRecordOne;



    @Before
    public void init(){
        // seed a record for test
        teamDAOImpl = new TeamDAOImpl();
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

        playerDAOImpl = new PlayerDAOImpl();
        playerTestRecordOne = new Player();
        playerTestRecordOne.setPlayerName("Test Player 1");
        playerTestRecordOne.setAge(1);
        playerTestRecordOne.setTeam(teamTestRecordOne);
        playerTestRecordOne.setNationality("Test Country");
        playerTestRecordOne.setPlayerPosition("GK");
        playerDAOImpl.save(playerTestRecordOne,teamTestRecordOne);
//
        playerTestRecordTwo = new Player();
        playerTestRecordTwo.setPlayerName("Test Player 2");
        playerTestRecordTwo.setAge(2);
        playerTestRecordTwo.setTeam(teamTestRecordOne);
        playerTestRecordTwo.setNationality("Test Country");
        playerTestRecordTwo.setPlayerPosition("CM");
        playerDAOImpl.save(playerTestRecordTwo,teamTestRecordOne);

        gameDAOImpl = new GameDAOImpl();
        gameTestRecordOne = new Game();
        gameTestRecordOne.setHomeTeam(teamTestRecordOne);
        gameTestRecordOne.setAwayTeam(teamTestRecordTwo);
        gameTestRecordOne.setHomeGoals(1);
        gameTestRecordOne.setHomeLosts(0);
        gameTestRecordOne.setHomeMatchResult("Win");
        gameDAOImpl.save(gameTestRecordOne,teamTestRecordOne);


    }

    @After
    public void cleanup(){
        teamDAOImpl.deleteTeamByName(teamTestRecordOne.getTeamName());
        teamDAOImpl.deleteTeamByName(teamTestRecordTwo.getTeamName());

//        playerDAOImpl.deleteById(playerTestRecordOne.getId());
//        playerDAOImpl.deleteById(playerTestRecordTwo.getId());
//        gameDAOImpl.deleteById(gameTestRecordOne.getId());
//        teamDAOImpl.deleteById(teamTestRecordOne.getId());
//        teamDAOImpl.deleteById(teamTestRecordTwo.getId());
//        teamDAOImpl.deleteById(teamTestRecordThree.getId());
        teamDAOImpl = null;
        playerDAOImpl=null;
        gameDAOImpl=null;

    }


    @Test
    @Transactional
    public void getTeamsTest(){
        List<Team> teams = teamDAOImpl.getTeams();
        for(Team team : teams){
            System.out.println(team);
        }
        assertEquals(2,teams.size());
    }


    @Test
    @Transactional
    public void updateTeamByIdTest(){
        int updatedCount = teamDAOImpl.updateTeamHomeWin(teamTestRecordOne.getId(),3);
        teamDAOImpl.getTeamById(teamTestRecordOne.getId()).toString();
        assertEquals(1,updatedCount);
    }


    @Test
    @Transactional
    public void getTeamByIdTest(){
        teamDAOImpl.getTeamById(teamTestRecordTwo.getId());
        assertNotNull(teamDAOImpl.getTeamById(teamTestRecordTwo.getId()));
    }

    @Test
    public void getPlayersByTeamTest(){
        List<Player> players = teamDAOImpl.getPlayersByTeamId(teamTestRecordOne.getId());
        assertEquals(2,players.size());
    }

    @Test
    @Transactional
    public void getTeamByNameTest(){
        teamDAOImpl.getTeamByName(teamTestRecordOne.getTeamName());
        assertNotNull(teamDAOImpl.getTeamByName(teamTestRecordOne.getTeamName()));
    }

//
//    @Test
//    public void getGameByHomeTeamIdTest(){
//        List<Game> games = teamDAOImpl.getGamesByHomeTeamId(gameTestRecordOne.getId());
//        assertEquals(1,games.size());
//    }

    @Test
    @Transactional
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
