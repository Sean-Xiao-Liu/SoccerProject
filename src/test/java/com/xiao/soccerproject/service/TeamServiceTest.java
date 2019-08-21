//package com.xiao.soccerproject.service;
//
//import com.xiao.soccerproject.init.AppInitializer;
//import com.xiao.soccerproject.model.Player;
//import com.xiao.soccerproject.model.Team;
//import com.xiao.soccerproject.service.TeamService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppInitializer.class)
//
//public class TeamServiceTest {
//    @Autowired
//    private TeamService teamService;
//
//    @Autowired
//    private PlayerService playerService;
//
//    private Team teamTestRecordOne;
//    private Team teamTestRecordTwo;
//    private Player playerTestRecordOne;
//    private Player playerTestRecordTwo;
//
//    @Before
//    public void init() {
//        // seed a record for test
//
//        teamTestRecordOne = new Team();
//        teamTestRecordOne.setTeamName("Test Team 1");
//        teamTestRecordOne.setHomeWin(1);
//        teamTestRecordOne.setAwayWin(1);
//        teamTestRecordOne.setHomeLoss(1);
//        teamTestRecordOne.setAwayLoss(1);
//        teamService.save(teamTestRecordOne);
//
//        teamTestRecordTwo = new Team();
//        teamTestRecordTwo.setTeamName("Test Team 2");
//        teamTestRecordTwo.setHomeWin(2);
//        teamTestRecordTwo.setAwayWin(2);
//        teamTestRecordTwo.setHomeLoss(2);
//        teamTestRecordTwo.setAwayLoss(2);
//        teamService.save(teamTestRecordTwo);
//
//        playerTestRecordOne = new Player();
//        playerTestRecordOne.setPlayerName("Test Player 1");
//        playerTestRecordOne.setAge(1);
//        playerTestRecordOne.setTeam(teamTestRecordOne);
//        playerTestRecordOne.setNationality("Test Country");
//        playerTestRecordOne.setPlayerPosition("GK");
//        playerService.save(playerTestRecordOne,teamTestRecordOne);
////
//        playerTestRecordTwo = new Player();
//        playerTestRecordTwo.setPlayerName("Test Player 2");
//        playerTestRecordTwo.setAge(2);
//        playerTestRecordTwo.setTeam(teamTestRecordOne);
//        playerTestRecordTwo.setNationality("Test Country");
//        playerTestRecordTwo.setPlayerPosition("CM");
//        playerService.save(playerTestRecordTwo,teamTestRecordOne);
//
//    }
//
//    @After
//    public void cleanup() {
//        playerService.deleteById(playerTestRecordOne.getId());
//        playerService.deleteById(playerTestRecordTwo.getId());
//        teamService.deleteById(teamTestRecordOne.getId());
//        teamService.deleteById(teamTestRecordTwo.getId());
//        teamService = null;
//    }
//
//
//    @Test
//    @Transactional
//    public void getTeamsTest(){
//        List<Team> teams = teamService.getTeams();
//        for(Team team : teams){
//            System.out.println(team);
//        }
//        assertEquals(2,teams.size());
//    }
//
//    @Test
//    @Transactional
//    public void updateTeamByIdTest(){
//        int updatedCount = teamService.updateTeamHomeWin(teamTestRecordOne.getId(),3);
//        teamService.getTeamById(teamTestRecordOne.getId()).toString();
//        assertEquals(1,updatedCount);
//    }
//
//    @Test
//    @Transactional
//    public void getTeamByIdTest(){
//        teamService.getTeamById(teamTestRecordTwo.getId());
//        assertNotNull(teamService.getTeamById(teamTestRecordTwo.getId()));
//    }
//
////    @Ignore
//    @Test
//    @Transactional
//    public void getPlayersByTeamTest(){
//        List<Player> players = teamService.getPlayersByTeamId(teamTestRecordOne.getId());
//        assertEquals(2,players.size());
//    }
//
//    @Test
//    @Transactional
//    public void getTeamByNameTest(){
//        teamService.getTeamByName(teamTestRecordOne.getTeamName());
//        assertNotNull(teamService.getTeamByName(teamTestRecordOne.getTeamName()));
//    }
//}