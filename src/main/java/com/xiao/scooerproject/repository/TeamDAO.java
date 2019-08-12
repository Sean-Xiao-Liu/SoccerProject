package com.xiao.scooerproject.repository;

import com.xiao.soccerproject.model.Team;

import java.util.List;

public interface TeamDAO {
    boolean save(Team teams);
    int updateTeamHomeWin(long id, int homeWin);
    int deleteById(long id);
    List<Team> getTeams();
    Team getTeamById(long id);


}
