package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class PlayerDAO {
    static final String DB_URL = "jdbc:postgresql://localhost:5431/SoccerProject_db";
    static final String USER = "admin";
    static final String PASS = "123456";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //method 1
    //read all content in the table
    public List<Player> getPlayer(){
        List<Player> Player = new ArrayList<>();
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
            sql = "SELECT * FROM Player";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String playerId = rs.getString("playerid");
                String teamId = rs.getString("teamid");
                String playerName = rs.getString("playername");
                int age = rs.getInt("age");
                String playerPosition = rs.getString("playerposition");
                String nationality = rs.getString("nationality");

                //Fill the object
                Player players = new Player();
                players.setPlayerid(playerId);
                players.setTeamid(teamId);
                players.setPlayername(playerName);
                players.setAge(age);
                players.setPlayerposition(playerPosition);
                players.setNationality(nationality);
                Player.add(players);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            //STEP 6: finally block used to close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

            logger.debug(String.format("xxxxxxx"));
            logger.info("logger works!") ;
        }
        return Player;
    }

    public static void main(String[] args) {
        PlayerDAO obj = new PlayerDAO();
        List<Player> players = obj.getPlayer();
        for(Player p : players){
            System.out.println(p.toString());
        }

    }








}




