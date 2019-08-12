package com.xiao.soccerproject.model;

import javax.persistence.*;

@Entity
@Table(name = "Games")
public class Game{

//    @EmbeddedId
//    private GameCompositeKey gameCompositeKey;
//    private String matchid;
//    private String ishome;

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "home_team_id")
    private int homeTeamId;

    @Column(name = "away_team_id")
    private int awayTeamId;


    @Column(name = "home_goals")
    private int homeGoals;

    @Column(name = "home_losts")
    private int homeLosts;

    @Column(name = "home_match_result")
    private String homeMatchResult;

//    public GameCompositeKey getGameCompositeKey() {
//        return gameCompositeKey;
//    }
//
//    public void setGameCompositeKey(GameCompositeKey gameCompositeKey) {
//        this.gameCompositeKey = gameCompositeKey;
//    }
//
//    public int getId() {
//        return gameCompositeKey.getId();
//    }
//
//    public void setId(long id) {
//        gameCompositeKey.setId(id);
//    }
//
//    public String getIsHome() {
//        return gameCompositeKey.getIsHome();
//    }
//
//    public void setIsHome(String isHome) {
//        gameCompositeKey.setIsHome(isHome);
//    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
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

    public String toString(){
        return "the home team is " + this.homeTeamId + " , and the away team is " + this.awayTeamId +  " , they played the match " + this.id;
    }

}
