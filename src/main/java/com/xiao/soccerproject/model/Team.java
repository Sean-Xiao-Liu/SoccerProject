package com.xiao.soccerproject.model;

public class Team {
    private String teamname;
    private String teamid;
    private int homewin;
    private int awaywin;
    private int homeloss;
    private int awayloss;
    private int matcheswon;
    private int matcheslost;
    private int matchesdrawn;
    private int totalmatches;
    private int points;
    private int finishposition;
    private int homegoals;
    private int awaygoals;
    private int goalsscored;
    private int goalsconceded;
    private int goaldifference;

    public String getTeamname (){return teamname;}
    public String getTeamid (){return teamid;}
    public int getHomewin (){return homewin;}
    public int getAwaywin (){return awaywin;}
    public int getHomeloss(){return homeloss;}
    public int getAwayloss(){return awayloss;}
    public int getMatcheswon(){return matcheswon;}
    public int getMatcheslost(){return matcheslost;}
    public int getMatchesdrawn(){return matchesdrawn;}
    public int getTotalmatches(){return totalmatches;}
    public int getPoints(){return points;}
    public int getFinishposition(){return finishposition;}
    public int getHomegoals(){return homegoals;}
    public int getAwaygoals(){return awaygoals;}
    public int getGoalsscored(){return goalsscored;}
    public int getGoalsconceded(){return goalsconceded;}
    public int getGoaldifference(){return goaldifference;}

    public void setTeamname (String teamname){this.teamname = teamname;}
    public void setTeamid (String teamid){this.teamid = teamid;}
    public void setHomewin (int homewin){this.homewin = homewin;}
    public void setAwaywin (int awaywin){this.awaywin = awaywin;}
    public void setHomeloss(int homeloss){this.homeloss = homeloss;}
    public void setAwayloss(int awayloss){this.awayloss = awayloss;}
    public void setMatcheswon(int matcheswon){this.matcheswon = matcheswon;}
    public void setMatcheslost(int matcheslost){this.matcheslost = matcheslost;}
    public void setMatchesdrawn(int matchesdrawn){this.matchesdrawn = matchesdrawn;}
    public void setTotalmatches(int totalmatches){this.totalmatches = totalmatches;}
    public void setPoints(int points){this.points = points;}
    public void setFinishposition(int finishposition){this.finishposition = finishposition;}
    public void setHomegoals(int homegoals){this.homegoals = homegoals;}
    public void setAwaygoals(int awaygoals){this.awaygoals = awaygoals;}
    public void setGoalsscored(int goalsscored){this.goalsscored = goalsscored;}
    public void setGoalsconceded(int goalsconceded){this.goalsconceded = goalsconceded;}
    public void setGoaldifference(int goaldifference){this.goaldifference = goaldifference;}

    public String toString() {
        return "the team  name is " + this.teamname + ", the home win times are " + this.homewin;
    }


}
