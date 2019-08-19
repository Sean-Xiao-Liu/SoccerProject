package com.xiao.soccerproject.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="team_name")
    private String teamName;

    @Column(name = "home_win")
    private int homeWin;

    @Column(name = "away_win")
    private int awayWin;

    @Column(name = "home_loss")
    private int homeLoss;

    @Column(name = "away_loss")
    private int awayLoss;

    //relationship with Player table
    @OneToMany(mappedBy = "team", orphanRemoval = true, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Player> players;

    //relationship with Games table
    @OneToMany(mappedBy = "homeTeam",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Game> homeGames;

    @OneToMany(mappedBy = "awayTeam",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Game> awayGames;

    /*getters and setters*/

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public int getHomeWin() {
        return homeWin;
    }

    public void setHomeWin(int homeWin) {
        this.homeWin = homeWin;
    }

    public int getAwayWin() {
        return awayWin;
    }

    public void setAwayWin(int awayWin) {
        this.awayWin = awayWin;
    }

    public int getHomeLoss() {
        return homeLoss;
    }

    public void setHomeLoss(int homeLoss) {
        this.homeLoss = homeLoss;
    }

    public int getAwayLoss() {
        return awayLoss;
    }

    public void setAwayLoss(int awayLoss) {
        this.awayLoss = awayLoss;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Game> getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(List<Game> homeGames) {
        this.homeGames = homeGames;
    }

    public List<Game> getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(List<Game> awayGames) {
        this.awayGames = awayGames;
    }

    public String toString() {
        return "the team  name is " + this.teamName + ", the team id is "+ this.id + " , the home win times are " + this.homeWin;
    }


}
