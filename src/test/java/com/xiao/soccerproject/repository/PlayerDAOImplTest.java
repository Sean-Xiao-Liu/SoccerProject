package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PlayerDAOImplTest {
    private PlayerDAOImpl playerDAOImpl;
    private Player playerTestRecordOne;
    private Player playerTestRecordTwo;
    private TeamDAOImpl teamDAOImpl;
    private Team teamTestRecordOne;
    private Team teamTestRecordTwo;

    @Before
    public void init(){

        teamDAOImpl = new TeamDAOImpl();
        teamTestRecordOne = new Team();
//        teamTestRecordOne.setId(1);
        teamTestRecordOne.setTeamName("Test Team 1");
        teamTestRecordOne.setHomeWin(1);
        teamTestRecordOne.setAwayWin(1);
        teamTestRecordOne.setHomeLoss(1);
        teamTestRecordOne.setAwayLoss(1);
        teamDAOImpl.save(teamTestRecordOne);

        teamTestRecordTwo = new Team();
//        teamTestRecordTwo.setId(2);
        teamTestRecordTwo.setTeamName("Test Team 2");
        teamTestRecordTwo.setHomeWin(2);
        teamTestRecordTwo.setAwayWin(2);
        teamTestRecordTwo.setHomeLoss(2);
        teamTestRecordTwo.setAwayLoss(2);
        teamDAOImpl.save(teamTestRecordTwo);

        // seed two records for test
        playerDAOImpl = new PlayerDAOImpl();
        playerTestRecordOne = new Player();
//        playerTestRecordOne.setId(1);
        playerTestRecordOne.setPlayerName("Test Player 1");
        playerTestRecordOne.setAge(1);
        playerTestRecordOne.setTeam(teamTestRecordOne);
        playerTestRecordOne.setNationality("Test Country");
        playerTestRecordOne.setPlayerPosition("GK");
        playerDAOImpl.save(playerTestRecordOne,teamTestRecordOne);

        playerTestRecordTwo = new Player();
//        playerTestRecordTwo.setId(2);
        playerTestRecordTwo.setPlayerName("Test Player 2");
        playerTestRecordTwo.setAge(2);
        playerTestRecordTwo.setTeam(teamTestRecordTwo);
        playerTestRecordTwo.setNationality("Test Country");
        playerTestRecordTwo.setPlayerPosition("CM");
        playerDAOImpl.save(playerTestRecordTwo,teamTestRecordTwo);

    }

    @After
    public void cleanup(){
        playerDAOImpl.deleteById(playerTestRecordOne.getId());
        playerDAOImpl.deleteById(playerTestRecordTwo.getId());
        teamDAOImpl.deleteById(teamTestRecordOne.getId());
        teamDAOImpl.deleteById(teamTestRecordTwo.getId());
        playerDAOImpl = null;
        assertNull(playerDAOImpl);
    }

    @Test
    public void getPlayersTest(){
        List<Player> players = playerDAOImpl.getPlayers();
        for(Player player : players){
            System.out.println(player);
        }
        assertEquals(2,players.size());//
    }

    @Test
    public void updatePlayerByIdTest(){ // why there is no logger in console?
        int updatedCount = playerDAOImpl.updatePlayerAge(playerTestRecordOne.getId(),3);
        assertEquals(1,updatedCount);
    }


    @Test
    public void getPlayerByIdTest(){
        playerDAOImpl.getPlayerById(playerTestRecordOne.getId());
        assertNotNull(playerDAOImpl.getPlayerById(playerTestRecordOne.getId()));
    }
}
