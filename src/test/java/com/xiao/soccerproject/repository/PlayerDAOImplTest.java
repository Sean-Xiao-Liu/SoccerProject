package com.xiao.soccerproject.repository;

import com.xiao.scooerproject.repository.PlayerDAOImpl;
import com.xiao.soccerproject.model.Player;
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

    @Before
    public void init(){
        // seed two records for test
        playerDAOImpl = new PlayerDAOImpl();
        playerTestRecordOne = new Player();
        playerTestRecordOne.setId(1);
        playerTestRecordOne.setPlayerName("Test Player 1");
        playerTestRecordOne.setAge(1);
        playerTestRecordOne.setTeamId(1);
        playerTestRecordOne.setNationality("Test Country");
        playerTestRecordOne.setPlayerPosition("GK");
        playerDAOImpl.save(playerTestRecordOne);

        playerTestRecordTwo = new Player();
        playerTestRecordTwo.setId(2);
        playerTestRecordTwo.setPlayerName("Test Player 2");
        playerTestRecordTwo.setAge(2);
        playerTestRecordTwo.setTeamId(2);
        playerTestRecordTwo.setNationality("Test Country");
        playerTestRecordTwo.setPlayerPosition("CM");
        playerDAOImpl.save(playerTestRecordTwo);

    }

    @After
    public void cleanup(){
        playerDAOImpl.deleteById(1);
        playerDAOImpl.deleteById(2);
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
        int updatedCount = playerDAOImpl.updatePlayerAge(1,3);
        assertEquals(1,updatedCount);
    }


    @Test
    public void getPlayerByIdTest(){
        playerDAOImpl.getPlayerById(1);
        assertNotNull(playerDAOImpl.getPlayerById(1));
    }
}
