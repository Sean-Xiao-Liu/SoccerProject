package com.xiao.soccerproject.model;

import javax.persistence.*;
import com.xiao.soccerproject.model.Team;

@Entity
@Table(name = "Games")
public class Game{

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "home_goals")
    private int homeGoals;

    @Column(name = "home_losts")
    private int homeLosts;

    @Column(name = "home_match_result")
    private String homeMatchResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id")
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

//    @Override
//    public String toString(){
//        return "the home team is " + this.getHomeTeam() + " , and the away team is " + this.getAwayTeam() +  " , they played the match " + this.id;
//    }

}
