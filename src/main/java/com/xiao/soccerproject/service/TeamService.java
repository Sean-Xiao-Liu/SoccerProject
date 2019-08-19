package com.xiao.soccerproject.service;

import com.xiao.soccerproject.repository.TeamDAO;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamService {
    @Autowired
    private TeamDAO teamDAO;

    public boolean save(Team teams){return teamDAO.save(teams);}
    public int updateTeamHomeWin(long id, int homeWin){return teamDAO.updateTeamHomeWin(id,homeWin);}
    public int deleteById(long id){return teamDAO.deleteById(id);}
    //    int deleteByName(String name);
    public List<Team> getTeams(){return teamDAO.getTeams();}
    public Team getTeamById(long id){return  teamDAO.getTeamById(id);}
    //    Team getTeamByName(String name);
    public List<Player> getPlayersByTeamId(long id){return teamDAO.getPlayersByTeamId(id);}
}
