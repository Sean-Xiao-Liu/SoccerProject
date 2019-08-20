package com.xiao.soccerproject.service;

import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.repository.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameDAO gameDAO;

    public boolean save(Game games, Team teams){return gameDAO.save(games,teams);}
    public int updateHomeGoals(long id, int homeGoals){return  gameDAO.updateHomeGoals(id,homeGoals);}
    public int deleteById(long id){
        return gameDAO.deleteById(id);
    }
    //    int deleteByName(String name);
    public  List<Game> getGames(){return gameDAO.getGames();}
    public Game getGameById(long id){return gameDAO.getGameById(id);}
//    Game getGameByName(String name);
}