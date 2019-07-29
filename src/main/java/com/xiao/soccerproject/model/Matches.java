package com.xiao.soccerproject.model;

public class Matches {

    private String matchid;
    private String ishome;
    private String teamid;
    private int goals;
    private int losts;
    private String matchresult;
    private int shots;
    private int shotsontarget;
    private int fouls;
    private int corner;
    private int offsides;
    private int yellowcard;
    private int redcard;
    private String formation;
    private double passsuccessrate;
    private double possessionpercentage;
    private int passes;
    private int averagepassstreak;


    public String getMatchid(){return matchid;}
    public String getIshome(){return ishome;}
    public String getTeamid(){return teamid;}
    public int getGoals(){return goals;}
    public int getLosts(){return losts;}
    public String getMatchresult(){return matchresult;}
    public int getShots(){return shots;}
    public int getShotsontarget(){return shotsontarget;}
    public int getFouls(){return fouls;}
    public int getCorner(){return corner;}
    public int getOffsides(){return offsides;}
    public int getYellowcard(){return yellowcard;}
    public int getRedcard(){return redcard;}
    public String getFormation(){return formation;}
    public double getPasssuccessrate(){return passsuccessrate;}
    public double getPossessionpercentage(){return possessionpercentage;}
    public int getPasses(){return passes;}
    public int getAveragepassstreak(){return averagepassstreak;}

    public void setMatchid(String matchid){this.matchid = matchid;}
    public void setIshome(String ishome){this.ishome = ishome;}
    public void setTeamid(String teamid){this.teamid = teamid;}
    public void setGoals(int goals){this.goals = goals;}
    public void setLosts(int losts){this.losts = losts;}
    public void setMatchresult(String matchresult){this.matchresult = matchresult;}
    public void setShots(int shots){this.shots = shots;}
    public void setShotsontarset(int shotsontarget){this.shotsontarget = shotsontarget;}
    public void setFouls(int fouls){this.fouls = fouls;}
    public void setCorner(int corner){this.corner = corner;}
    public void setOffsides(int offsides){this.offsides = offsides;}
    public void setYellowcard(int yellowcard){this.yellowcard = yellowcard;}
    public void setRedcard(int redcard){this.redcard = redcard;}
    public void setFormation(String formation){this.formation = formation;}
    public void setPasssuccessrate(double passsuccessrate){this.passsuccessrate = passsuccessrate;}
    public void setPossessionpercentage(double possessionpercentage){this.possessionpercentage = possessionpercentage;}
    public void setPasses(int passes){this.passes = passes;}
    public void setAveragepassstreak(int averagepassstreak){this.averagepassstreak = averagepassstreak;}

    public String toString(){
        return "The team  id is " + matchid ;
    }
}
