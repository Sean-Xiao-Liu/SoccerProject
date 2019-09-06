package com.xiao.soccerproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Players")
public class Player {
//    public interface PlayerInfo extends Team.PlayerInfo{};
    @Id // don't forget the primary key, or lead to code 255
//    @Column(name = "id")
    @JsonView(Team.PlayerInfo.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonView(Team.PlayerInfo.class)
    @Column(name = "player_name")
    private String playerName;

    @JsonView(Team.PlayerInfo.class)
    @Column(name = "age")
    private int age;

    @JsonView(Team.PlayerInfo.class)
    @Column(name = "player_position")
    private String playerPosition;

    @Column(name = "nationality")
    @JsonView(Team.PlayerInfo.class)
    private String nationality;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id" )// @Column will lead to duplication at this point
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

    @Override
    public int hashCode() {
        return Objects.hash(id, playerName);// generate hashCode
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;

        if(!playerName.equals(other.playerName))
            return false;

        return true;
    }
}
