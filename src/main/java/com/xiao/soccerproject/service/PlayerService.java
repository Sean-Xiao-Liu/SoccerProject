package com.xiao.soccerproject.service;

import com.xiao.soccerproject.repository.PlayerDAO;
import com.xiao.soccerproject.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    public boolean save(Player players, long teamId){return playerDAO.save(players,teamId);}
    public int updatePlayerAge(long id, int age){return playerDAO.updatePlayerAge(id,age);}
    public int deleteById(long id){return playerDAO.deleteById(id);}
    public int deletePlayerByName(String playerName){
       return playerDAO.deletePlayerByName(playerName);
    }
    public List<Player> getPlayers(){return playerDAO.getPlayers();}
    public Player getPlayerById(long id){return  playerDAO.getPlayerById(id);};
    public Player getPlayerByName(String playerName){return playerDAO.getPlayerByName(playerName);}
}
