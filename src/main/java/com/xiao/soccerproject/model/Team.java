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
    private int id;

    @Column(name = "home_win")
    private int homeWin;

    @Column(name = "away_win")
    private int awayWin;

    @Column(name = "home_loss")
    private int homeLoss;

    @Column(name = "away_loss")
    private int awayLoss;

//    @Column(name = "matches_won")
//    private int matchesWon;
//
//    @Column(name = "matches_lost")
//    private int matchesLost;
//
//    @Column(name = "matches_drawn")
//    private int matchesDrawn;
//
//    @Column(name = "total_matches")
//    private int totalMatches;
//
//    @Column(name = "points")
//    private int points;
//
//    @Column(name = "finish_position")
//    private int finishPosition;
//
//    @Column(name = "home_goals")
//    private int homeGoals;
//
//    @Column(name = "away_goals")
//    private int awayGoals;
//
//    @Column(name = "goals_scored")
//    private int goalsScored;
//
//    @Column(name = "goals_conceded")
//    private int goalsConceded;
//
//    @Column(name = "goal_difference")
//    private int goalDifference;


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
