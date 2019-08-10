package com.xiao.soccerproject.repository;

import com.xiao.scooerproject.repository.PlayerDAOimpl;
import com.xiao.soccerproject.model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PlayerDAOimplTest {
    private PlayerDAOimpl playerDAOimpl;
    private Player playerTestRecord;

    @Before
    public void init(){
        // seed a record for test
        playerDAOimpl = new PlayerDAOimpl();
        playerTestRecord = new Player();
        playerTestRecord.setId(99);
        playerTestRecord.setPlayerName("Test Player");
        playerTestRecord.setAge(99);
        playerTestRecord.setTeamId(99);
        playerTestRecord.setNationality("Test Country");
        playerTestRecord.setPlayerPosition("GK");
        boolean result = playerDAOimpl.save(playerTestRecord);

    }

    @After
    public void cleanup(){
        playerDAOimpl.deleteById(99);
        playerDAOimpl = null;
        assertNull(playerDAOimpl);
    }

    @Test
    public void getPlayersTest(){
        List<Player> players = playerDAOimpl.getPlayers();
        for(Player player : players){
            System.out.println(player);
        }
        assertEquals(6,players.size());// 7 original reccord plus one
        assertNotNull(playerTestRecord.getId());
    }

    @Test
    public void updatePlayerByIdTest(){ // why there is no logger in console?
        int updatedCount = playerDAOimpl.updatePlayerAge(99,99);
        assertEquals(1,updatedCount);
    }


    @Test
    public void getPlayerByIdTest(){
        playerDAOimpl.getPlayerById(99);
    }
}
