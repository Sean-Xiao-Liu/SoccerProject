package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Team;

import java.util.List;
import java.util.Set;

public interface GameDAO {
    boolean save(Game games, Team teams);
    int updateHomeGoals(long id, int homeGoals);
    int deleteById(long id);
//    int deleteByName(String name);
    List<Game> getGames();
    Game getGameById(long id);
}
