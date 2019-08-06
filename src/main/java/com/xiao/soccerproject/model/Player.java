package com.xiao.soccerproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Player")
public class Player {
    @Id // don't forget the primary key, or lead to code 255
    @Column(name = "player_id")
    private String playerId;

    @Column(name = "team_id")
    private String teamId;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "age")
    private int age;

    @Column(name = "player_position")
    private String playerPosition;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "overall_score")
    private int overallScore;

    @Column(name = "pace")
    private int pace;

    @Column(name = "acceleration")
    private int acceleration;

    @Column(name = "sprint_speed")
    private int sprintSpeed;

    @Column(name = "dribbling")
    private int dribbling;

    @Column(name = "agility")
    private int agility;

    @Column(name = "balance")
    private int balance;


    @Column(name = "reactions")
    private int reactions;


    @Column(name = "ball_control")
    private int ballControl;


    @Column(name = "composure")
    private int composure;


    @Column(name = "shooting")
    private int shooting;


    @Column(name = "positioning")
    private int positioning;


    @Column(name = "finishing")
    private int finishing;


    @Column(name = "shot_power")
    private int shotPower;


    @Column(name = "long_shots")
    private int longShots;


    @Column(name = "volleys")
    private int volleys;


    @Column(name = "penalties")
    private int penalties;


    @Column(name = "passing_ability")
    private int passingAbility;


    @Column(name = "vision")
    private int vision;


    @Column(name = "crossing")
    private int crossing;


    @Column(name = "free_kick")
    private int freeKick;


    @Column(name = "short_pass")
    private int shortPass;


    @Column(name = "long_pass")
    private int longPass;


    @Column(name = "pass_curve")
    private int passCurve;


    @Column(name = "defending")
    private int defending;


    @Column(name = "interceptions")
    private int interceptions;


    @Column(name = "heading")
    private int heading;


    @Column(name = "marking")
    private int marking;


    @Column(name = "standing_tackle")
    private int standingTackle;


    @Column(name = "sliding_tackle")
    private int slidingTackle;


    @Column(name = "physicality")
    private int physicality;


    @Column(name = "jumping")
    private int jumping;


    @Column(name = "stamina")
    private int stamina;


    @Column(name = "strength")
    private int strength;


    @Column(name = "aggression")
    private int aggression;


    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSprintSpeed() {
        return sprintSpeed;
    }

    public void setSprintSpeed(int sprintSpeed) {
        this.sprintSpeed = sprintSpeed;
    }

    public int getDribbling() {
        return dribbling;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getReactions() {
        return reactions;
    }

    public void setReactions(int reactions) {
        this.reactions = reactions;
    }

    public int getBallControl() {
        return ballControl;
    }

    public void setBallControl(int ballControl) {
        this.ballControl = ballControl;
    }

    public int getComposure() {
        return composure;
    }

    public void setComposure(int composure) {
        this.composure = composure;
    }

    public int getShooting() {
        return shooting;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public int getPositioning() {
        return positioning;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }

    public int getFinishing() {
        return finishing;
    }

    public void setFinishing(int finishing) {
        this.finishing = finishing;
    }

    public int getShotPower() {
        return shotPower;
    }

    public void setShotPower(int shotPower) {
        this.shotPower = shotPower;
    }

    public int getLongShots() {
        return longShots;
    }

    public void setLongShots(int longShots) {
        this.longShots = longShots;
    }

    public int getVolleys() {
        return volleys;
    }

    public void setVolleys(int volleys) {
        this.volleys = volleys;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public int getPassingAbility() {
        return passingAbility;
    }

    public void setPassingAbility(int passingAbility) {
        this.passingAbility = passingAbility;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public int getCrossing() {
        return crossing;
    }

    public void setCrossing(int crossing) {
        this.crossing = crossing;
    }

    public int getFreeKick() {
        return freeKick;
    }

    public void setFreeKick(int freeKick) {
        this.freeKick = freeKick;
    }

    public int getShortPass() {
        return shortPass;
    }

    public void setShortPass(int shortPass) {
        this.shortPass = shortPass;
    }

    public int getLongPass() {
        return longPass;
    }

    public void setLongPass(int longPass) {
        this.longPass = longPass;
    }

    public int getPassCurve() {
        return passCurve;
    }

    public void setPassCurve(int passCurve) {
        this.passCurve = passCurve;
    }

    public int getDefending() {
        return defending;
    }

    public void setDefending(int defending) {
        this.defending = defending;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getMarking() {
        return marking;
    }

    public void setMarking(int marking) {
        this.marking = marking;
    }

    public int getStandingTackle() {
        return standingTackle;
    }

    public void setStandingTackle(int standingTackle) {
        this.standingTackle = standingTackle;
    }

    public int getSlidingTackle() {
        return slidingTackle;
    }

    public void setSlidingTackle(int slidingTackle) {
        this.slidingTackle = slidingTackle;
    }

    public int getPhysicality() {
        return physicality;
    }

    public void setPhysicality(int physicality) {
        this.physicality = physicality;
    }

    public int getJumping() {
        return jumping;
    }

    public void setJumping(int jumping) {
        this.jumping = jumping;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAggression() {
        return aggression;
    }

    public void setAggression(int aggression) {
        this.aggression = aggression;
    }

    public String toString(){
        return "The player name is "  + this.playerName + ", he is " + this.age + " years old from " + this.nationality + " who plays " + this.playerPosition;
    }

}
