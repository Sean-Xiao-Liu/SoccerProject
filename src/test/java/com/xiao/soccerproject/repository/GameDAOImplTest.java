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
    public Game gameTestRecordOne;
    public Game gameTestRecordTwo;

   @Before
    public void init(){
       gameDAOImpl = new GameDAOImpl();
       gameTestRecordOne = new Game();
       gameTestRecordOne.setId(1);
       gameTestRecordOne.setHomeTeamId(1);
       gameTestRecordOne.setAwayTeamId(2);
       gameTestRecordOne.setHomeGoals(1);
       gameTestRecordOne.setHomeLosts(0);
       gameTestRecordOne.setHomeMatchResult("Win");
       gameDAOImpl.save(gameTestRecordOne);

       gameTestRecordTwo = new Game();
       gameTestRecordTwo.setId(2);
       gameTestRecordTwo.setHomeTeamId(3);
       gameTestRecordTwo.setAwayTeamId(4);
       gameTestRecordTwo.setHomeGoals(0);
       gameTestRecordTwo.setHomeLosts(1);
       gameTestRecordTwo.setHomeMatchResult("Lose");
       gameDAOImpl.save(gameTestRecordTwo);
   }

   @After
   public void cleanup(){
       gameDAOImpl.deleteById(1);
       gameDAOImpl.deleteById(2);
       gameDAOImpl = null;
       assertNull(gameDAOImpl);
   }

    @Test
    public void getGamesTest(){
        List<Game> games = gameDAOImpl.getGames();
        for(Game game : games){
            System.out.println(game);
        }
        assertEquals(2,games.size());
    }

    @Test
    public void updateHomeGoalsTest(){
        int updatedCount = gameDAOImpl.updateHomeGoals(1,2);
        assertEquals(1,updatedCount);
    }


    @Test
    public void getGameByIdTest(){
        gameDAOImpl.getGameById(2);
        assertNotNull(gameDAOImpl.getGameById(2));
    }

}
