package com.xiao.soccerproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Team")
public class Team {
    @Column(name="team_name")
    private String teamname;
    @Id
    @Column(name="team_id")
    private String teamid;

    @Column(name = "home_win")
    private int homewin;

    @Column(name = "away_win")
    private int awaywin;

    @Column(name = "home_loss")
    private int homeloss;

    @Column(name = "away_loss")
    private int awayloss;

    @Column(name = "matches_won")
    private int matcheswon;

    @Column(name = "matches_lost")
    private int matcheslost;

    @Column(name = "matches_drawn")
    private int matchesdrawn;

    @Column(name = "total_matches")
    private int totalmatches;

    @Column(name = "points")
    private int points;

    @Column(name = "finish_position")
    private int finishposition;

    @Column(name = "home_goals")
    private int homegoals;

    @Column(name = "away_goals")
    private int awaygoals;

    @Column(name = "goals_scored")
    private int goalsscored;

    @Column(name = "goals_conceded")
    private int goalsconceded;

    @Column(name = "goal_difference")
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
