package com.xiao.soccerproject.repository;

import com.xiao.scooerproject.repository.GameDAOImpl;
import com.xiao.soccerproject.model.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameDAOImplTest {
    public GameDAOImpl gameDAOImpl;
    public Game gameTestRecord;

   @Before
    public void init(){
       gameDAOImpl = new GameDAOImpl();
       gameTestRecord = new Game();
       gameTestRecord.setId(99);
       gameTestRecord.setHomeTeamId(999);
       gameTestRecord.setAwayTeamId(111);
       gameTestRecord.setHomeGoals(999);
       gameTestRecord.setHomeLosts(111);
       gameTestRecord.setHomeMatchResult("Win");
       boolean result = gameDAOImpl.save(gameTestRecord);
   }

   @After
   public void cleanup(){
       gameDAOImpl.deleteById(99);
       //gameDAOImpl.deleteById(gameTestRecord.getId());
       gameDAOImpl = null;
       assertNull(gameDAOImpl);
   }

    @Test
    public void getGamesTest(){
        List<Game> games = gameDAOImpl.getGames();
        for(Game game : games){
            System.out.println(game);
        }
        assertEquals(1,games.size());// 3 original reccord plus one
        assertNotNull(gameTestRecord.getId());
    }

    @Test
    public void updateHomeGoalsTest(){ // why there is no logger in console?
        int updatedCount = gameDAOImpl.updateHomeGoals(99,888);
        assertEquals(1,updatedCount);
    }


    @Test
    public void getGameByIdTest(){
        gameDAOImpl.getGameById(99);
    }

}
