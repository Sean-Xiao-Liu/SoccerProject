package com.xiao.soccerproject.repository;

import static org.junit.Assert.*;
import com.xiao.soccerproject.util.HibernateUtil;
import com.xiao.scooerproject.repository.TeamDAOImpl;
import com.xiao.soccerproject.model.Team;
import org.junit.*;


import javax.transaction.Transactional;
import java.util.List;

public class TeamDAOImplTest {
private TeamDAOImpl teamDAOImpl;
private Team teamTestRecordOne;
private Team teamTestRecordTwo;

    @Before
    public void init(){
        // seed a record for test
        teamDAOImpl = new TeamDAOImpl();
        teamTestRecordOne = new Team();
        teamTestRecordOne.setId(1);
        teamTestRecordOne.setTeamName("Test Team 1");
        teamTestRecordOne.setHomeWin(1);
        teamTestRecordOne.setAwayWin(1);
        teamTestRecordOne.setHomeLoss(1);
        teamTestRecordOne.setAwayLoss(1);
        teamDAOImpl.save(teamTestRecordOne);

        teamTestRecordTwo = new Team();
        teamTestRecordTwo.setId(2);
        teamTestRecordTwo.setTeamName("Test Team 2");
        teamTestRecordTwo.setHomeWin(2);
        teamTestRecordTwo.setAwayWin(2);
        teamTestRecordTwo.setHomeLoss(2);
        teamTestRecordTwo.setAwayLoss(2);
        teamDAOImpl.save(teamTestRecordTwo);

    }

    @After
    public void cleanup(){
        teamDAOImpl.deleteById(1);
        teamDAOImpl.deleteById(2);
        teamDAOImpl = null;
        assertNull(teamDAOImpl);
    }

    @Test
    @Transactional
    public void getTeamsTest(){
        List<Team> teams = teamDAOImpl.getTeams();
        for(Team team : teams){
            System.out.println(team);
        }
        assertEquals(2,teams.size());
    }

    @Test
    @Transactional
    public void updateTeamByIdTest(){
        int updatedCount = teamDAOImpl.updateTeamHomeWin(1,3);
        teamDAOImpl.getTeamById(1).toString();
        assertEquals(1,updatedCount);
    }


    @Test
    @Transactional
    public void getTeamByIdTest(){
        teamDAOImpl.getTeamById(2);
        assertNotNull(teamDAOImpl.getTeamById(2));
    }

}
