package com.xiao.soccerproject.model;

public class Player {
    private String playerid;
    private String teamid;
    private String playername;
    private int age;
    private String playerposition;
    private String nationality;
    private int height;
    private int weight;
    private int overallscore;
    private int pace;
    private int acceleration;
    private int sprintspeed;
    private int dribbling;
    private int agility;
    private int balance;
    private int reactions;
    private int ballcontrol;
    private int composure;
    private int shooting;
    private int positioning;
    private int finishing;
    private int shotpower;
    private int longshots;
    private int volleys;
    private int penalties;
    private int passingability;
    private int vision;
    private int crossing;
    private int freekick;
    private int shortpass;
    private int longpass;
    private int passcurve;
    private int defending;
    private int interceptions;
    private int heading;
    private int marking;
    private int standingtackle;
    private int slidingtackle;
    private int physicality;
    private int jumping;
    private int stamina;
    private int strength;
    private int aggression;

    public String getPlayerid(){return playerid;}
    public String getTeamid(){return teamid;}
    public String getPlayername(){return playername;}
    public int getAge(){return age;}
    public String getPlayerposition(){return playerposition;}
    public String getNationality(){return nationality;}
    public int getHeight(){return height;}
    public int getWeight(){return weight;}
    public int getOverallscore(){return overallscore;}
    public int getPace(){return pace;}
    public int getAcceleration(){return acceleration;}
    public int getSprintspeed(){return sprintspeed;}
    public int getDribbling(){return dribbling;}
    public int getAgility(){return agility;}
    public int getBalance(){return balance;}
    public int getReactions(){return reactions;}
    public int getBallcontrol(){return ballcontrol;}
    public int getComposure(){return composure;}
    public int getShooting(){return shooting;}
    public int getPositioning(){return positioning;}
    public int getFinishing(){return finishing;}
    public int getShotpower(){return shotpower;}
    public int getLongshots(){return longshots;}
    public int getVolleys(){return volleys;}
    public int getPenalties(){return penalties;}
    public int getPassingability(){return passingability;}
    public int getVision(){return vision;}
    public int getCrossing(){return crossing;}
    public int getFreekick(){return freekick;}
    public int getShortpass(){return shortpass;}
    public int getLongpass(){return longpass;}
    public int getPasscurve(){return passcurve;}
    public int getDefending(){return defending;}
    public int getInterceptions(){return interceptions;}
    public int getHeading(){return heading;}
    public int getMarking(){return marking;}
    public int getStandingtackle(){return standingtackle;}
    public int getSlidingtackle(){return slidingtackle;}
    public int getPhysicality(){return physicality;}
    public int getJumping(){return jumping;}
    public int getStamina(){return stamina;}
    public int getStrength(){return strength;}
    public int getAggression(){return aggression;}


    public void setPlayerid(String playerid){this.playerid = playerid;}
    public void setTeamid(String teamid){this.teamid = teamid;}
    public void setPlayername(String playername){this.playername = playername;}
    public void setAge(int age){this.age = age;}
    public void setPlayerposition(String playerposition){this.playerposition = playerposition;}
    public void setNationality(String nationality){this.nationality = nationality;}
    public void setHeight(int height){this.height = height;}
    public void setWeight(int weight){this.weight = weight;}
    public void setOverallscore(int overallscore){this.overallscore = overallscore;}
    public void setPace(int pace){this.pace = pace;}
    public void setAcceleration(int acceleration){this.acceleration = acceleration;}
    public void setSprintspeed(int sprintspeed){this.sprintspeed = sprintspeed;}
    public void setDribbling(int dribbling){this.dribbling = dribbling;}
    public void setAgility(int agility){this.agility = agility;}
    public void setBalance(int balance){this.balance = balance;}
    public void setReactions(int reactions){this.reactions = reactions;}
    public void setBallcontrol(int ballcontrol){this.ballcontrol = ballcontrol;}
    public void setComposure(int composure){this.composure = composure;}
    public void setShooting(int shooting){this.shooting = shooting;}
    public void setPositioning(int positioning){this.positioning = positioning;}
    public void setFinishing(int finishing){this.finishing = finishing;}
    public void setShotpower(int shotpower){this.shotpower = shotpower;}
    public void setLongshots(int longshots){this.longshots = longshots;}
    public void setVolleys(int volleys){this.volleys = volleys;}
    public void setPenalties(int penalties){this.penalties = penalties;}
    public void setPassingability(int passingability){this.passingability = passingability;}
    public void setVision(int vision){this.vision = vision;}
    public void setCrossing(int crossing){this.crossing = crossing;}
    public void setFreekick(int freekick){this.freekick = freekick;}
    public void setShortpass(int shortpass){this.shortpass = shortpass;}
    public void setLongpass(int longpass){this.longpass = longpass;}
    public void setPasscurve(int passcurve){this.passcurve = passcurve;}
    public void setDefending(int defending){this.defending = defending;}
    public void setInterceptions(int interceptions){this.interceptions = interceptions;}
    public void setHeading(int heading){this.heading = heading;}
    public void setMarking(int marking){this.marking = marking;}
    public void setStandingtackle(int standingtackle){this.standingtackle = standingtackle;}
    public void setSlidingtackle(int slidingtackle){this.slidingtackle = slidingtackle;}
    public void setPhysicality(int physicality){this.physicality = physicality;}
    public void setJumping(int jumping){this.jumping = jumping;}
    public void setStamina(int stamina){this.stamina = stamina;}
    public void setStrength(int strength){this.strength = strength;}
    public void setAggression(int aggression){this.aggression = aggression;}

   public String toString(){
        return "The player name is "  + playername + ", he is " + age + " years old from " + nationality + " who plays " + playerposition;
    }

}
