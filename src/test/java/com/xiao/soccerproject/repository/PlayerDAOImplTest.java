package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)

public class PlayerDAOImplTest {

    @Autowired
    private PlayerDAO playerDAOImpl;

    private Player playerTestRecordOne;
    private Player playerTestRecordTwo;
    private Player playerTestRecordThree;

    @Autowired
    private TeamDAO teamDAOImpl;

    private Team teamTestRecordOne;
    private Team teamTestRecordTwo;

    @Before
    public void init(){

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

        // seed two records for test
        playerDAOImpl = new PlayerDAOImpl();
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
        playerDAOImpl.save(playerTestRecordTwo,teamTestRecordTwo.getId());

    }

    @After
    public void cleanup(){
        playerDAOImpl.deleteById(playerTestRecordOne.getId());
        playerDAOImpl.deleteById(playerTestRecordTwo.getId());
        teamDAOImpl.deleteById(teamTestRecordOne.getId());
        teamDAOImpl.deleteById(teamTestRecordTwo.getId());
        playerDAOImpl = null;
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

    @Test
    public void getPlayerByNameTest(){
        playerDAOImpl.getPlayerByName(playerTestRecordOne.getPlayerName());
        assertNotNull(playerDAOImpl.getPlayerByName(playerTestRecordOne.getPlayerName()));
    }

    @Test
    public void deletePlayerByNameTest(){
        playerTestRecordThree = new Player();
        playerTestRecordThree.setPlayerName("Test Player 3");
        playerTestRecordThree.setAge(3);
        playerTestRecordThree.setTeam(teamTestRecordTwo);
        playerTestRecordThree.setNationality("Test Country");
        playerTestRecordThree.setPlayerPosition("CB");
        playerDAOImpl.save(playerTestRecordThree,teamTestRecordTwo.getId());

        int deleteCount = playerDAOImpl.deletePlayerByName(playerTestRecordThree.getPlayerName());
        assertEquals(1,deleteCount);
    }

}
