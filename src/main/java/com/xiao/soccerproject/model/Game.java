package com.xiao.soccerproject.model;

import javax.persistence.*;

@Entity
@Table(name = "Game")
public class Game{

    @EmbeddedId
    private GameCompositeKey gameCompositeKey;
//    private String matchid;
//    private String ishome;

    @Column(name = "team_id")
    private String teamId;

    @Column(name = "goals")
    private int goals;

    @Column(name = "losts")
    private int losts;

    @Column(name = "match_result")
    private String matchResult;

    @Column(name = "shots")
    private int shots;

    @Column(name = "shots_on_target")
    private int shotsOnTarget;

    @Column(name = "fouls")
    private int fouls;

    @Column(name = "corner")
    private int corner;

    @Column(name = "off_sides")
    private int offSides;

    @Column(name = "yellow_card")
    private int yellowCard;

    @Column(name = "red_card")
    private int redCard;

    @Column(name = "formation")
    private String formation;

    @Column(name = "pass_success_rate")
    private double passSuccessRate;

    @Column(name = "possession_percentage")
    private double possessionPercentage;

    @Column(name = "passes")
    private int passes;

    @Column(name = "average_pass_streak")
    private int averagePassStreak;

    public GameCompositeKey getGameCompositeKey() {
        return gameCompositeKey;
    }

    public void setGameCompositeKey(GameCompositeKey gameCompositeKey) {
        this.gameCompositeKey = gameCompositeKey;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
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

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setShotsOnTarget(int shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public int getCorner() {
        return corner;
    }

    public void setCorner(int corner) {
        this.corner = corner;
    }

    public int getOffSides() {
        return offSides;
    }

    public void setOffSides(int offSides) {
        this.offSides = offSides;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }

    public int getRedCard() {
        return redCard;
    }

    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public double getPassSuccessRate() {
        return passSuccessRate;
    }

    public void setPassSuccessRate(double passSuccessRate) {
        this.passSuccessRate = passSuccessRate;
    }

    public double getPossessionPercentage() {
        return possessionPercentage;
    }

    public void setPossessionPercentage(double possessionPercentage) {
        this.possessionPercentage = possessionPercentage;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    public int getAveragePassStreak() {
        return averagePassStreak;
    }

    public void setAveragePassStreak(int averagePassStreak) {
        this.averagePassStreak = averagePassStreak;
    }

    public String getMatchid() {
        return gameCompositeKey.getMatchid();
    }

    public void setMatchid(String matchid) {
        gameCompositeKey.setMatchid(matchid);
    }

    public String getIshome() {
        return gameCompositeKey.getIshome();
    }

    public void setIshome(String ishome) {
        gameCompositeKey.setIshome(ishome);
    }

    public String toString(){
        return "the team id is " + this.teamId ;
    }

}
