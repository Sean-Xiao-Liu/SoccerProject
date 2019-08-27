package com.xiao.soccerproject.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xiao.soccerproject.model.Team;

@Entity
@Table(name = "Games")
public class Game{

//    public interface GameInfo{};

    @Id
//    @Column(name = "id")
    @JsonView(Team.GameInfo.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonView(Team.GameInfo.class)
    @Column(name = "home_goals")
    private int homeGoals;

    @JsonView(Team.GameInfo.class)
    @Column(name = "home_losts")
    private int homeLosts;

    @JsonView(Team.GameInfo.class)
    @Column(name = "home_match_result")
    private String homeMatchResult;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id")
    @JsonView(Team.GameInfo.class)
    private Team homeTeam;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id")
    @JsonView(Team.GameInfo.class)
    private Team awayTeam;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getHomeLosts() {
        return homeLosts;
    }

    public void setHomeLosts(int homeLosts) {
        this.homeLosts = homeLosts;
    }

    public String getHomeMatchResult() {
        return homeMatchResult;
    }

    public void setHomeMatchResult(String homeMatchResult) {
        this.homeMatchResult = homeMatchResult;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
}
