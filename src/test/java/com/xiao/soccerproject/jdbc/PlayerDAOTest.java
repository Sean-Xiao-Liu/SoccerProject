package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlayerDAOTest {
    private PlayerDAO playerDAO;

    @Before
    public void init() {
        playerDAO = new PlayerDAO();
    }

    @After
    public void cleanup(){
        playerDAO = null;
    }

    @Test
    public void getPlayerTest() {
        List<Player> players = playerDAO.getPlayer();
        for (Player p : players) {
            System.out.println(p.toString());
        }
        Assert.assertEquals(5, players.size());
    }
}
