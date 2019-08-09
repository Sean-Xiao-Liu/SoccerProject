package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Player;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PlayerDAOTest {
    private static Logger logger = LoggerFactory.getLogger(PlayerDAOTest.class);
    private PlayerDAO playerDAO;

    @BeforeClass
    public static void startTest(){
        logger.info("Before class : test");
    }

    @AfterClass
    public static void exitTest(){
        logger.info("After class : test");
    }

    @Before
    public void init() {
        playerDAO = new PlayerDAO();
        logger.info("Before : test start");
    }

    @After
    public void cleanup(){
        playerDAO = null;
        logger.info("After : test end");
    }

    @Test
    public void getPlayerTest() {
        List<Player> players = playerDAO.getPlayer();
        for (Player p : players) {
            System.out.println(p.toString());
        }
//        Assert.assertEquals(5, players.size());

    }

    @Test
    public void insertPlayer(){
        playerDAO.insertPlayer(99,99,"Player Test");
    }


    @Test
    public void deletePlayer(){
        playerDAO.deletePlayer(99);
    }

}
