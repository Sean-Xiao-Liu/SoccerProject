package com.xiao.soccerproject.service;

import com.xiao.soccerproject.repository.PlayerDAO;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    //    boolean update(Player players);
    public boolean save(Player players, Team teams){return playerDAO.save(players,teams);}
    public int updatePlayerAge(long id, int age){return playerDAO.updatePlayerAge(id,age);}
    public int deleteById(long id){return playerDAO.deleteById(id);}
    //    int deleteByName(String name);
    public List<Player> getPlayers(){return playerDAO.getPlayers();}
    public Player getPlayerById(long id){return  playerDAO.getPlayerById(id);};
//    Player getPlayerByName(String name);
}
