package com.xiao.soccerproject.repository;

import static org.junit.Assert.*;
import com.xiao.scooerproject.repository.TeamDAOImpl;
import com.xiao.soccerproject.model.Team;
import org.junit.*;


import java.util.List;

public class TeamDAOImplTest {
private TeamDAOImpl teamDAOImpl;
private Team teamTestRecord;

    @Before
    public void init(){
        // seed a record for test
        teamDAOImpl = new TeamDAOImpl();
        teamTestRecord = new Team();
        teamTestRecord.setId(99);
        teamTestRecord.setTeamName("Test Team");
        boolean result = teamDAOImpl.save(teamTestRecord);

    }

    @After
    public void cleanup(){
        teamDAOImpl.deleteById(99);
        teamDAOImpl = null;
        assertNull(teamDAOImpl);
    }

    @Test
    public void getTeamsTest(){
        List<Team> teams = teamDAOImpl.getTeams();
        for(Team team : teams){
            System.out.println(team);
        }
        assertEquals(1,teams.size());// 7 original reccord plus one
        assertNotNull(teamTestRecord.getId());
    }

    @Test
    public void updateTeamByIdTest(){ // why there is no logger in console?
        int updatedCount = teamDAOImpl.updateTeamHomeWin(99,1);
        assertEquals(1,updatedCount);
    }


    @Test
    public void getTeamByIdTest(){
        teamDAOImpl.getTeamById(99);
        assertNotNull(teamDAOImpl.getTeamById(99));
    }

}
