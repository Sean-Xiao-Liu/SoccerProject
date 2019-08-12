package com.xiao.soccerproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teams")
public class Team {
    @Column(name="team_name")
    private String teamName;
    @Id
    @Column(name="id")
    private long id;

    @Column(name = "home_win")
    private int homeWin;

    @Column(name = "away_win")
    private int awayWin;

    @Column(name = "home_loss")
    private int homeLoss;

    @Column(name = "away_loss")
    private int awayLoss;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHomeWin() {
        return homeWin;
    }

    public void setHomeWin(int homeWin) {
        this.homeWin = homeWin;
    }

    public int getAwayWin() {
        return awayWin;
    }

    public void setAwayWin(int awayWin) {
        this.awayWin = awayWin;
    }

    public int getHomeLoss() {
        return homeLoss;
    }

    public void setHomeLoss(int homeLoss) {
        this.homeLoss = homeLoss;
    }

    public int getAwayLoss() {
        return awayLoss;
    }

    public void setAwayLoss(int awayLoss) {
        this.awayLoss = awayLoss;
    }

    public String toString() {
        return "the team  name is " + this.teamName + ", the team id is "+ this.id + " , the home win times are " + this.homeWin;
    }


}
