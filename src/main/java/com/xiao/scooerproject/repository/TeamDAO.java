package com.xiao.scooerproject.repository;

import com.xiao.soccerproject.model.Team;

import java.util.List;

public interface TeamDAO {
    boolean save(Team teams);
    boolean update(Team teams);
    boolean delete(String teamName);
    List<Team> getTeams();
    Team getTeamById(String teamId);


}
