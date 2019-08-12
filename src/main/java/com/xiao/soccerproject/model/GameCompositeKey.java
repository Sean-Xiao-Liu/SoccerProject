//package com.xiao.soccerproject.model;
//
///*
//1. default constructor
//2. implement Serializable interface
//3. implement of equals() and hashcode()
// */
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//
//@Embeddable
//public class GameCompositeKey implements Serializable {
//
//    @Column(name = "id")
//    private long id;
//
//    @Column(name = "is_home")
//    private String isHome;
//
//    public GameCompositeKey(long id, String isHome) {
//        this.id = id;
//        this.isHome = isHome;
//    }
//    public GameCompositeKey(){}; // default constructor
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getIsHome() {
//        return isHome;
//    }
//
//    public void setIsHome(String isHome) {
//        this.isHome = isHome;
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//}
