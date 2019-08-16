package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.util.HibernateUtil;
import com.xiao.scooerproject.repository.GameDAOImpl;
import com.xiao.scooerproject.repository.TeamDAOImpl;
import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

public class GameDAOImplTest {
    public TeamDAOImpl teamDAOImpl;
    public Team teamTestRecordOne;
    public Team teamTestRecordTwo;
    public GameDAOImpl gameDAOImpl;
    public Game gameTestRecordOne;
    public Game gameTestRecordTwo;


   @Before
    public void init(){

       teamDAOImpl = new TeamDAOImpl();
       teamTestRecordOne = new Team();
//       teamTestRecordOne.setId(1);
       teamTestRecordOne.setTeamName("Test Team 1");
       teamTestRecordOne.setHomeWin(1);
       teamTestRecordOne.setAwayWin(1);
       teamTestRecordOne.setHomeLoss(1);
       teamTestRecordOne.setAwayLoss(1);
       teamDAOImpl.save(teamTestRecordOne);

       teamTestRecordTwo = new Team();
//       teamTestRecordTwo.setId(2);
       teamTestRecordTwo.setTeamName("Test Team 2");
       teamTestRecordTwo.setHomeWin(2);
       teamTestRecordTwo.setAwayWin(2);
       teamTestRecordTwo.setHomeLoss(2);
       teamTestRecordTwo.setAwayLoss(2);
       teamDAOImpl.save(teamTestRecordTwo);


       gameDAOImpl = new GameDAOImpl();
       gameTestRecordOne = new Game();
//       gameTestRecordOne.setId(1);
       gameTestRecordOne.setHomeTeam(teamTestRecordOne);
       gameTestRecordOne.setAwayTeam(teamTestRecordTwo);
       gameTestRecordOne.setHomeGoals(1);
       gameTestRecordOne.setHomeLosts(0);
       gameTestRecordOne.setHomeMatchResult("Win");
       gameDAOImpl.save(gameTestRecordOne,teamTestRecordOne);

       gameTestRecordTwo = new Game();
//       gameTestRecordTwo.setId(2);
       gameTestRecordOne.setHomeTeam(teamTestRecordTwo);
       gameTestRecordOne.setAwayTeam(teamTestRecordOne);
       gameTestRecordTwo.setHomeGoals(0);
       gameTestRecordTwo.setHomeLosts(1);
       gameTestRecordTwo.setHomeMatchResult("Lose");
       gameDAOImpl.save(gameTestRecordTwo,teamTestRecordTwo);
   }

   @After
   public void cleanup(){
       gameDAOImpl.deleteById(gameTestRecordOne.getId());
       gameDAOImpl.deleteById(gameTestRecordTwo.getId());
       teamDAOImpl.deleteById(teamTestRecordOne.getId());
       teamDAOImpl.deleteById(teamTestRecordTwo.getId());
       gameDAOImpl = null;
       assertNull(gameDAOImpl);
   }

    @Test
    @Transactional
    public void getGamesTest(){
        List<Game> games = gameDAOImpl.getGames();
        for(Game game : games){
            System.out.println(game);
        }
        assertEquals(5,games.size());
    }

    @Test
    @Transactional
    public void updateHomeGoalsTest(){
        int updatedCount = gameDAOImpl.updateHomeGoals(1,2);
        assertEquals(1,updatedCount);
    }


    @Test
    @Transactional
    public void getGameByIdTest(){
        gameDAOImpl.getGameById(2);
        gameDAOImpl.getGameById(1);
        assertNotNull(gameDAOImpl.getGameById(2));
    }

}
