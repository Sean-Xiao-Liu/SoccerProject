package com.xiao.scooerproject.repository;

import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Team;

import java.util.List;

public interface GameDAO {
    boolean save(Game games, Team teams);
    int updateHomeGoals(long id, int homeGoals);
    int deleteById(long id);
    List<Game> getGames();
    Game getGameById(long id);
}
