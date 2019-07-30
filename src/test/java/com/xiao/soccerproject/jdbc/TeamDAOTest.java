package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TeamDAOTest {
    private TeamDAO teamDAO;

    @Before
    public void init(){
        teamDAO = new TeamDAO();
    }

    @After
    public void cleanup(){
        teamDAO = null;
    }

    @Test

    public void getTeamTest(){
        List<Team> teams = teamDAO.getTeam();
        for (Team t : teams) {
            System.out.println(t.toString());
        }
    }
}
