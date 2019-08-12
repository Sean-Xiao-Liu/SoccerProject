package com.xiao.scooerproject.repository;

import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;

import java.util.List;

public interface PlayerDAO {
//    boolean update(Player players);
    boolean save(Player players);
    int updatePlayerAge(long id, int age);
    int deleteById(long id);
    List<Player> getPlayers();
    Player getPlayerById(long id);
}
