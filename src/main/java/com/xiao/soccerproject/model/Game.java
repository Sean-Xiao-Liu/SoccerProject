package com.xiao.soccerproject.model;

import javax.persistence.*;

@Entity
@Table(name = "Games")
public class Game{

    @EmbeddedId
    private GameCompositeKey gameCompositeKey;
//    private String matchid;
//    private String ishome;

    @Column(name = "team_id")
    private int teamId;

    @Column(name = "goals")
    private int goals;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getLosts() {
        return losts;
    }

    public void setLosts(int losts) {
        this.losts = losts;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    @Column(name = "losts")
    private int losts;

    @Column(name = "match_result")
    private String matchResult;

//    @Column(name = "shots")
//    private int shots;
//
//    @Column(name = "shots_on_target")
//    private int shotsOnTarget;
//
//    @Column(name = "fouls")
//    private int fouls;
//
//    @Column(name = "corner")
//    private int corner;
//
//    @Column(name = "off_sides")
//    private int offSides;
//
//    @Column(name = "yellow_card")
//    private int yellowCard;
//
//    @Column(name = "red_card")
//    private int redCard;
//
//    @Column(name = "formation")
//    private String formation;
//
//    @Column(name = "pass_success_rate")
//    private double passSuccessRate;
//
//    @Column(name = "possession_percentage")
//    private double possessionPercentage;
//
//    @Column(name = "passes")
//    private int passes;
//
//    @Column(name = "average_pass_streak")
//    private int averagePassStreak;

    public GameCompositeKey getGameCompositeKey() {
        return gameCompositeKey;
    }

    public void setGameCompositeKey(GameCompositeKey gameCompositeKey) {
        this.gameCompositeKey = gameCompositeKey;
    }


    public int getId() {
        return gameCompositeKey.getId();
    }

    public void setId(int id) {
        gameCompositeKey.setId(id);
    }

    public String getIsHome() {
        return gameCompositeKey.getIsHome();
    }

    public void setIsHome(String isHome) {
        gameCompositeKey.setIsHome(isHome);
    }


    public String toString(){
        return "the team id is " + this.teamId ;
    }

}
