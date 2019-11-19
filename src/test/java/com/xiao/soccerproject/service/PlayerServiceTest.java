package com.xiao.soccerproject.service;

import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)

public class PlayerServiceTest {

    @Autowired
    private Logger logger;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    private Player playerTestRecordOne;
    private Player playerTestRecordTwo;
    private Team teamTestRecordOne;
    private Team teamTestRecordTwo;

    @Before
    public void init(){

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

        // seed two records for test
        playerTestRecordOne = new Player();
        playerTestRecordOne.setPlayerName("Test Player 1");
        playerTestRecordOne.setAge(1);
        playerTestRecordOne.setTeam(teamTestRecordOne);
        playerTestRecordOne.setNationality("Test Country");
        playerTestRecordOne.setPlayerPosition("GK");
        playerService.save(playerTestRecordOne,teamTestRecordOne.getId());

        playerTestRecordTwo = new Player();
        playerTestRecordTwo.setPlayerName("Test Player 2");
        playerTestRecordTwo.setAge(2);
        playerTestRecordTwo.setTeam(teamTestRecordTwo);
        playerTestRecordTwo.setNationality("Test Country");
        playerTestRecordTwo.setPlayerPosition("CM");
        playerService.save(playerTestRecordTwo,teamTestRecordTwo.getId());

    }

    @After
    public void cleanup(){
        playerService.deleteById(playerTestRecordOne.getId());
//        playerService.deleteById(playerTestRecordTwo.getId());
        playerService.deletePlayerByName(playerTestRecordTwo.getPlayerName());
        teamService.deleteTeamByName(teamTestRecordOne.getTeamName());
        teamService.deleteTeamByName(teamTestRecordTwo.getTeamName());
    }

    @Test
    public void getPlayersTest(){
        List<Player> players = playerService.getPlayers();
        for(Player player : players){
            System.out.println(player);
        }
        assertEquals(2,players.size());//
    }

    @Test
    public void updatePlayerByIdTest(){ // why there is no logger in console?
        int updatedCount = playerService.updatePlayerAge(playerTestRecordOne.getId(),3);
        assertEquals(1,updatedCount);
    }


    @Test
    public void getPlayerByIdTest(){
        playerService.getPlayerById(playerTestRecordOne.getId());
        assertNotNull(playerService.getPlayerById(playerTestRecordOne.getId()));
    }

    @Test
    public void getPlayerByNameTest(){
        playerService.getPlayerByName(playerTestRecordOne.getPlayerName());
        assertNotNull(playerService.getPlayerByName(playerTestRecordOne.getPlayerName()));
    }

    @Test
    public void updatePlayerTest(){
        long teamId = teamTestRecordOne.getId();
        playerTestRecordOne.setPlayerPosition("ST");
        logger.info(String.format("The player %s 's position is %s now",playerTestRecordOne.getPlayerName(),playerTestRecordOne.getPlayerPosition()));
        int updateCount = playerService.updatePlayer(playerTestRecordOne,teamId);
        assertEquals(1,updateCount);

    }
}


