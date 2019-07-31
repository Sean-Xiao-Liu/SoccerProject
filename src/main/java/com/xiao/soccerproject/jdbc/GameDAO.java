package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GameDAO {
    static final String DB_URL = "jdbc:postgresql://localhost:5431/SoccerProject_db";
    static final String USER = "admin";
    static final String PASS = "123456";
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //method 1
    //read all content in the table
    public List<Game> getGame(){
        List<Game> Game = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Game";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                String matchId = rs.getString("matchid");
                String teamId = rs.getString("teamid");
                String matchResult = rs.getString("matchresult");

                Game game = new Game();
                game.setMatchid(matchId);
                game.setTeamid(teamId);
                game.setMatchresult(matchResult);
                Game.add(game);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //STEP 6: finally block used to close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return Game; // this game is defined by :  List<Matches> Game = new ArrayList<>();
    }

    public static void main(String[] args) {


    }
}
