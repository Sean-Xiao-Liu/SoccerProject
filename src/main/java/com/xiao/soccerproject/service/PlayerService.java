package com.xiao.soccerproject.service;

import com.xiao.soccerproject.repository.PlayerDAO;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerService {

    @Autowired
    private PlayerDAO playerDAO;
    //    boolean update(Player players);
    boolean save(Player players, Team teams){return playerDAO.save(players,teams);}
//    int updatePlayerAge(long id, int age);
//    int deleteById(long id);
//    //    int deleteByName(String name);
//    List<Player> getPlayers();
//    Player getPlayerById(long id);
//    Player getPlayerByName(String name);
}
