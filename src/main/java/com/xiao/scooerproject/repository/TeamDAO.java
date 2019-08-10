package com.xiao.scooerproject.repository;

import com.xiao.soccerproject.model.Team;

import java.util.List;

public interface TeamDAO {
    boolean save(Team teams);
    int updateTeamHomeWin(int id, int homeWin);
    int deleteById(int id);
    List<Team> getTeams();
    Team getTeamById(int id);


}
