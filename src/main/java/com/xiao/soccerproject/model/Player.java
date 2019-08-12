package com.xiao.soccerproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Players")
public class Player {
    @Id // don't forget the primary key, or lead to code 255
    @Column(name = "id")
    private long id;

    @Column(name = "team_id")
    private int teamId;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "age")
    private int age;

    @Column(name = "player_position")
    private String playerPosition;

    @Column(name = "nationality")
    private String nationality;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
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

    public String toString(){
        return "The player name is "  + this.playerName + ", he is " + this.age + " years old from " + this.nationality + " who plays " + this.playerPosition;
    }

}
