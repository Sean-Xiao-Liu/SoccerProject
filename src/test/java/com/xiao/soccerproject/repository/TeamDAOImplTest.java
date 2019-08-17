package com.xiao.soccerproject.repository;

import static org.junit.Assert.*;

import com.xiao.scooerproject.repository.PlayerDAOImpl;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.util.HibernateUtil;
import com.xiao.scooerproject.repository.TeamDAOImpl;
import com.xiao.soccerproject.model.Team;
import org.junit.*;


import javax.transaction.Transactional;
import java.util.List;

public class TeamDAOImplTest {
private TeamDAOImpl teamDAOImpl;
private Team teamTestRecordOne;
private Team teamTestRecordTwo;
private PlayerDAOImpl playerDAOImpl;
private Player playerTestRecordOne;
private Player playerTestRecordTwo;

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

    }

    @After
    public void cleanup(){
        playerDAOImpl.deleteById(playerTestRecordOne.getId());
        playerDAOImpl.deleteById(playerTestRecordTwo.getId());
        teamDAOImpl.deleteById(teamTestRecordOne.getId());
        teamDAOImpl.deleteById(teamTestRecordTwo.getId());
//        playerDAOImpl.deleteById(playerTestRecordOne.getId());
//        playerDAOImpl.deleteById(playerTestRecordTwo.getId());
        teamDAOImpl = null;
//        playerDAOImpl=null;

    }


    @Test
    //@Transactional
    public void getTeamsTest(){
        List<Team> teams = teamDAOImpl.getTeams();
        for(Team team : teams){
            System.out.println(team);
        }
        assertEquals(2,teams.size());
    }


    @Test
    //@Transactional
    public void updateTeamByIdTest(){
        int updatedCount = teamDAOImpl.updateTeamHomeWin(teamTestRecordOne.getId(),3);
        teamDAOImpl.getTeamById(teamTestRecordOne.getId()).toString();
        assertEquals(1,updatedCount);
    }


    @Test
    //@Transactional
    public void getTeamByIdTest(){
        teamDAOImpl.getTeamById(teamTestRecordTwo.getId());
        assertNotNull(teamDAOImpl.getTeamById(teamTestRecordTwo.getId()));
    }

    @Test
    public void getPlayersByTeamTest(){
        List<Player> players = teamDAOImpl.getPlayersByTeamId(teamTestRecordOne.getId());
        assertEquals(2,players.size());
    }

}
