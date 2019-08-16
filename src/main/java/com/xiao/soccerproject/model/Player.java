package com.xiao.soccerproject.model;

import javax.persistence.*;

@Entity
@Table(name = "Players")
public class Player {
    @Id // don't forget the primary key, or lead to code 255
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "age")
    private int age;

    @Column(name = "player_position")
    private String playerPosition;

    @Column(name = "nationality")
    private String nationality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")// @Column will lead to duplication at this point
    private Team team;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Team getTeam(Team teams) {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
