package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;

import java.util.List;
import java.util.Set;

public interface TeamDAO {
    boolean save(Team teams);
    int updateTeamHomeWin(long id, int homeWin);
    int deleteById(long id);
    int deleteTeamByName(String teamName);
    List<Team> getTeams();
    Team getTeamById(long id);
    Team getTeamByName(String teamName);
    List<Player> getPlayersByTeamId(long id);
//    List<Game> getGamesByHomeTeamId(long id);

}
