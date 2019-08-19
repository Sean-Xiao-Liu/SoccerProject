package com.xiao.soccerproject.service;

import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.repository.GameDAOImpl;
import com.xiao.soccerproject.repository.TeamDAOImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)

public class GameServiceTest {
    public TeamService teamService;
    public Team teamTestRecordOne;
    public Team teamTestRecordTwo;
    public GameService gameService;
    public Game gameTestRecordOne;
    public Game gameTestRecordTwo;

    @Before
    public void init(){

        teamTestRecordOne = new Team();
        teamTestRecordOne.setTeamName("Test Team 1");
        teamTestRecordOne.setHomeWin(1);
        teamTestRecordOne.setAwayWin(1);
        teamTestRecordOne.setHomeLoss(1);
        teamTestRecordOne.setAwayLoss(1);
        teamService.save(teamTestRecordOne);

        teamTestRecordTwo = new Team();
        teamTestRecordTwo.setTeamName("Test Team 2");
        teamTestRecordTwo.setHomeWin(2);
        teamTestRecordTwo.setAwayWin(2);
        teamTestRecordTwo.setHomeLoss(2);
        teamTestRecordTwo.setAwayLoss(2);
        teamService.save(teamTestRecordTwo);


        gameTestRecordOne = new Game();
        gameTestRecordOne.setHomeTeam(teamTestRecordOne);
        gameTestRecordOne.setAwayTeam(teamTestRecordTwo);
        gameTestRecordOne.setHomeGoals(1);
        gameTestRecordOne.setHomeLosts(0);
        gameTestRecordOne.setHomeMatchResult("Win");
        gameService.save(gameTestRecordOne,teamTestRecordOne);

        gameTestRecordTwo = new Game();
        gameTestRecordOne.setHomeTeam(teamTestRecordTwo);
        gameTestRecordOne.setAwayTeam(teamTestRecordOne);
        gameTestRecordTwo.setHomeGoals(0);
        gameTestRecordTwo.setHomeLosts(1);
        gameTestRecordTwo.setHomeMatchResult("Lose");
        gameService.save(gameTestRecordTwo,teamTestRecordTwo);
    }

    @After
    public void cleanup(){
        gameService.deleteById(gameTestRecordOne.getId());
        gameService.deleteById(gameTestRecordTwo.getId());
        teamService.deleteById(teamTestRecordOne.getId());
        teamService.deleteById(teamTestRecordTwo.getId());
        gameService = null;
        teamService = null;
    }


}
