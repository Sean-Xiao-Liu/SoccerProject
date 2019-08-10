package com.xiao.scooerproject.repository;

import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;

import java.util.List;

public interface PlayerDAO {
    boolean save(Player players);
    int updatePlayerAge(int id, int age);
    int deleteById(int id);
    List<Player> getPlayers();
    Player getPlayerById(int id);
}
