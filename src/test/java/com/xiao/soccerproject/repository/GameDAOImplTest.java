package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.model.Game;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)

public class GameDAOImplTest {

    @Autowired
    private TeamDAO teamDAOImpl;

//    public TeamDAOImpl teamDAOImpl; // Autowired

    public Team teamTestRecordOne;
    public Team teamTestRecordTwo;

    @Autowired
    private GameDAO gameDAOImpl;

//    public GameDAOImpl gameDAOImpl; // Autowired

    public Game gameTestRecordOne;
    public Game gameTestRecordTwo;


   @Before
    public void init(){

       //teamDAOImpl = new TeamDAOImpl();
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


//       gameDAOImpl = new GameDAOImpl();
       gameTestRecordOne = new Game();
       gameTestRecordOne.setHomeGoals(1);
       gameTestRecordOne.setHomeLosts(0);
       gameTestRecordOne.setHomeMatchResult("Win");
       gameDAOImpl.save(gameTestRecordOne,teamTestRecordOne.getId(),teamTestRecordTwo.getId());

       gameTestRecordTwo = new Game();
       gameTestRecordTwo.setHomeGoals(0);
       gameTestRecordTwo.setHomeLosts(1);
       gameTestRecordTwo.setHomeMatchResult("Lose");
       gameDAOImpl.save(gameTestRecordTwo,teamTestRecordTwo.getId(),teamTestRecordOne.getId());
   }

   @After
   public void cleanup(){

       gameDAOImpl.deleteById(gameTestRecordOne.getId());
       gameDAOImpl.deleteById(gameTestRecordTwo.getId());
       teamDAOImpl.deleteTeamByName(teamTestRecordOne.getTeamName());// use session delete instead of quary delete, when the inverse side record is  deleted, the corresponding owning side records are also deleted.
       teamDAOImpl.deleteTeamByName(teamTestRecordTwo.getTeamName());

//       teamDAOImpl.deleteById(teamTestRecordOne.getId());
//       teamDAOImpl.deleteById(teamTestRecordTwo.getId());
   }

    @Test
//    @Transactional
    public void getGamesTest(){
        List<Game> games = gameDAOImpl.getGames();
        for(Game game : games){
            System.out.println(game);
        }
        assertEquals(2,games.size());//
    }

    @Test
//    @Transactional
    public void updateHomeGoalsTest(){
        int updatedCount = gameDAOImpl.updateHomeGoals(gameTestRecordOne.getId(),2);
        assertEquals(1,updatedCount);
    }


    @Test
//    @Transactional
    public void getGameByIdTest(){
        gameDAOImpl.getGameById(gameTestRecordOne.getId());
        assertNotNull(gameDAOImpl.getGameById(gameTestRecordTwo.getId()));
    }

}
