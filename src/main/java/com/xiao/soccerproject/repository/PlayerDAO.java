package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;

import java.util.List;

public interface PlayerDAO {
//    boolean update(Player players);
    boolean save(Player players, long teamId);
    int updatePlayerAge(long id, int age);
    int deleteById(long id);
    int deletePlayerByName(String playerName);
    List<Player> getPlayers();
    Player getPlayerById(long id);
    Player getPlayerByName(String name);
    int updatePlayer(Player player, long teamId);
}
