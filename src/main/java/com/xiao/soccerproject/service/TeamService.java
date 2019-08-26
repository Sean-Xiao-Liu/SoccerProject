package com.xiao.soccerproject.service;

import com.xiao.soccerproject.repository.TeamDAO;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class TeamService {

    @Autowired
    private TeamDAO teamDAO;

    public boolean save(Team teams){return teamDAO.save(teams);}
    public int updateTeamHomeWin(long id, int homeWin){return teamDAO.updateTeamHomeWin(id,homeWin);}
    public int deleteById(long id){return teamDAO.deleteById(id);}
    public int deleteTeamByName(String teamName){return teamDAO.deleteTeamByName(teamName);}
    public List<Team> getTeams(){return teamDAO.getTeams();}
    public Team getTeamById(long id){return  teamDAO.getTeamById(id);}
    public Team getTeamByName(String teamName){return  teamDAO.getTeamByName(teamName);}
    public List<Player> getPlayersByTeamId(long id){return teamDAO.getPlayersByTeamId(id);}
    public int updateTeam(Team team){return teamDAO.updateTeam(team);}
}
