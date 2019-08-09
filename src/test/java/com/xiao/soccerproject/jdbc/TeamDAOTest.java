package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
//            assertEquals("",t.getTeamname());
            System.out.print(t.getTeamName());
            System.out.println(t.toString());
        }
    }


    @Test
    public void getTeamInfoTest(){
        Team team = teamDAO.getTeamInfo(15);
        System.out.println(team.toString());
    }


    @Test
    public void insertTeam(){
        int team2 = teamDAO.insertTeam("testTeam",21);
        System.out.println(team2);

    }

    @Test
    public void updateTeamTest(){
        int team1 = teamDAO.updateTeam(21,99); // update Real Madrid home win to 14
        System.out.println(" total updates required: "+team1);
    }

     @Test
    public void deleteTeam(){
        teamDAO.deleteTeam(21);
    }
}
