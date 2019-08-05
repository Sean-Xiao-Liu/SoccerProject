package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
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
        logger.info("Enter the method getPlayer");
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
            logger.error("The error message is "+e.getMessage());
        } finally {
            //STEP 6: finally block used to close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

//            logger.debug( "debug player size = "+ Player.size());
//            logger.info("info player size = " +  + Player.size()) ;
//            logger.trace("trace player size = " + Player.size());
//            logger.warn( "warn player size = "+ Player.size());
//            logger.error( " error player size = "+ Player.size());
        }
        logger.info("Exit the method getPlayer");
        return Player;

    }


    //method 2
    //insert record of player
    public int insertPlayer(String playerId,String teamId, String playerName) {
        List<Player> Player = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int result = 0;

        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "INSERT INTO Player (playerid, teamid, playername) " + "VALUES (? , ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, playerId);
            stmt.setString(2, teamId);
            stmt.setString(3, playerName);

            result = stmt.executeUpdate();

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
        return result;
    }

    // method 3
    // delete record of player from table Player
    public int deletePlayer(String playerId) {
        List<Player> Player = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int result = 0;

        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "DELETE FROM Player " + "WHERE playerid = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, playerId);

            result = stmt.executeUpdate();

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
        return result;
    }


    //method 4
    //update a



















    public static void main(String[] args) {
    }

}




