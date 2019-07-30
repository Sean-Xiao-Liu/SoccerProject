package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Matches;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MatchesDAOTest {
    private MatchesDAO matchesDAO;

    @Before
    public void init(){
        matchesDAO = new MatchesDAO();
    }

    @After
    public void cleanup(){
        matchesDAO = null;
    }

    @Test
    public void getMatchesTest(){

        List<Matches> matches = matchesDAO.getMatches();

        for(Matches m : matches){
            System.out.println(m.toString());
        }

    }

}
