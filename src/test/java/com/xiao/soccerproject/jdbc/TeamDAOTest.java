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

    @Test
    public void updateTeamTest(){
        int team1 = teamDAO.updateTeam("T15",2); // update Real Madrid home win
        System.out.println(" total updates required: "+team1);
    }

    @Test
    public void getTeamInfoTest(){
        Team team = teamDAO.getTeamInfo("T15");
        System.out.println(team.toString());
    }
}
