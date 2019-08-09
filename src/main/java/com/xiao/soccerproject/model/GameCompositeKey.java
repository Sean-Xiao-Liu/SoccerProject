package com.xiao.soccerproject.model;

/*
1. default constructor
2. implement Serializable interface
3. implement of equals() and hashcode()
 */

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GameCompositeKey implements Serializable {

    @Column(name = "id")
    private int id;

    @Column(name = "is_home")
    private String isHome;

    public GameCompositeKey(int id, String isHome) {
        this.id = id;
        this.isHome = isHome;
    }
    public GameCompositeKey(){}; // default constructor
//
//    public String getMatchid() {
//        return matchid;
//    }
//
//    public void setMatchid(String matchid) {
//        this.matchid = matchid;
//    }
//
//    public String getIshome() {
//        return ishome;
//    }
//
//    public void setIshome(String ishome) {
//        this.ishome = ishome;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsHome() {
        return isHome;
    }

    public void setIsHome(String isHome) {
        this.isHome = isHome;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
