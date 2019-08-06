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

    @Column(name = "match_id")
    private String matchid;

    @Column(name = "is_home")
    private String ishome;

    public GameCompositeKey(String matchid, String ishome) {
        this.matchid = matchid;
        this.ishome = ishome;
    }
    public GameCompositeKey(){}; // default constructor

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid;
    }

    public String getIshome() {
        return ishome;
    }

    public void setIshome(String ishome) {
        this.ishome = ishome;
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
