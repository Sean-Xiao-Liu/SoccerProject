package com.xiao.soccerproject.repository;

import static org.junit.Assert.*;
import com.xiao.scooerproject.repository.TeamDAOimpl;
import com.xiao.soccerproject.model.Team;
import org.junit.*;


import java.util.List;

public class TeamDAOimplTest {
private TeamDAOimpl teamDAOimpl;
private Team teamTestRecord;

    @Before
    public void init(){
        // seed a record for test
        teamDAOimpl = new TeamDAOimpl();
        teamTestRecord = new Team();
        teamTestRecord.setId(99);
        teamTestRecord.setTeamName("Test Team");
        boolean result = teamDAOimpl.save(teamTestRecord);

    }

    @After
    public void cleanup(){
        teamDAOimpl.deleteById(99);
        teamDAOimpl = null;
        assertNull(teamDAOimpl);
    }

    @Test
    public void getTeamsTest(){
        List<Team> teams = teamDAOimpl.getTeams();
        for(Team team : teams){
            System.out.println(team);
        }
        assertEquals(8,teams.size());// 7 original reccord plus one
        assertNotNull(teamTestRecord.getId());
    }

    @Test
    public void updateTeamByIdTest(){ // why there is no logger in console?
        int updatedCount = teamDAOimpl.updateTeamHomeWin(15,14);
        assertEquals(1,updatedCount);
    }


    @Test
    public void getTeamByIdTest(){
        teamDAOimpl.getTeamById(2);
        assertNotNull(teamDAOimpl.getTeamById(2));
    }

}
