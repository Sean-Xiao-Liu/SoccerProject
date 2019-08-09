package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GameDAOTest {
    private GameDAO gameDAO;

    @Before
    public void init(){
        gameDAO = new GameDAO();
    }

    @After
    public void cleanup(){
        gameDAO = null;
    }

    @Test
    public void getMatchesTest(){

        List<Game> game = gameDAO.getGame();

        for(Game g : game){
            System.out.println(g.toString());
        }

    }


    @Test
    public void insertGameTest(){
        int game1 = gameDAO.insertGame(99,"Test Home",99);
        System.out.println(game1);
    }

    @Test
    public void deleteGameTest(){
        gameDAO.deleteGame(99);
    }

    @Test
    public void updateGameTest(){
        int game2 = gameDAO.updateGame(99,99);
        System.out.println(game2);
    }
}
