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
            sql = "SELECT * FROM Players";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int teamId = rs.getInt("team_id");
                String playerName = rs.getString("player_name");
                int age = rs.getInt("age");
                String playerPosition = rs.getString("player_position");
                String nationality = rs.getString("nationality");

                //Fill the object
                Player players = new Player();
                players.setId(id);
                players.setTeamId(teamId);
                players.setPlayerName(playerName);
                players.setAge(age);
                players.setPlayerPosition(playerPosition);
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
    public int insertPlayer(int id,int teamId, String playerName) {
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
            String sql = "INSERT INTO Players (id, team_id, player_name) " + "VALUES (? , ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, teamId);
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
    public int deletePlayer(int id) {
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
            String sql = "DELETE FROM Players " + "WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

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


    public static void main(String[] args) {
    }

}




