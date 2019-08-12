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
    private Player playerTestRecord;

    @Before
    public void init(){
        // seed a record for test
        playerDAOImpl = new PlayerDAOImpl();
        playerTestRecord = new Player();
        playerTestRecord.setId(99);
        playerTestRecord.setPlayerName("Test Player");
        playerTestRecord.setAge(99);
        playerTestRecord.setTeamId(99);
        playerTestRecord.setNationality("Test Country");
        playerTestRecord.setPlayerPosition("GK");
        boolean result = playerDAOImpl.save(playerTestRecord);

    }

    @After
    public void cleanup(){
        playerDAOImpl.deleteById(99);
        playerDAOImpl = null;
        assertNull(playerDAOImpl);
    }

    @Test
    public void getPlayersTest(){
        List<Player> players = playerDAOImpl.getPlayers();
        for(Player player : players){
            System.out.println(player);
        }
        assertEquals(1,players.size());// 7 original reccord plus one
        assertNotNull(playerTestRecord.getId());
    }

    @Test
    public void updatePlayerByIdTest(){ // why there is no logger in console?
        int updatedCount = playerDAOImpl.updatePlayerAge(99,99);
        assertEquals(1,updatedCount);
    }


    @Test
    public void getPlayerByIdTest(){
        playerDAOImpl.getPlayerById(99);
    }
}
