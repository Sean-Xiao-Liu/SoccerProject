//package com.xiao.soccerproject.jdbc;
//
//import com.xiao.soccerproject.model.Game;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class GameDAO {
//    static final String DB_URL = "jdbc:postgresql://localhost:5431/SoccerProject_db";
//    static final String USER = "admin";
//    static final String PASS = "123456";
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//
//    //method 1
//    //read all content in the table
//    public List<Game> getGame(){
//        List<Game> Game = new ArrayList<>();
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            //STEP 3: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT * FROM Games";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                long id = rs.getLong("id");
//                int homeTeamId = rs.getInt("home_team_id");
//                int awayTeamID = rs.getInt("away_team_id");
//
//                Game game = new Game();
//
//                game.setId(id);
//                game.setHomeTeamId(homeTeamId);
//                game.setAwayTeamId(awayTeamID);
//                Game.add(game);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //STEP 6: finally block used to close resources
//            try {
//                if (rs != null) rs.close();
//                if (stmt != null) stmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        return Game; // this game is defined by :  List<Game> Game = new ArrayList<>();
//    }
//
//    //method 2
//    //insert a game record
//
//    public int insertGame(long id, int homeTeamId,int awayTeamId) {
//        List<Game> Game = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        int result = 0;
//
//        try {
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            //STEP 3: Execute a query
//            System.out.println("Creating statement...");
//            String sql = "INSERT INTO Games (id,home_team_id, away_team_id) " + "VALUES (? , ? , ?)";
//            stmt = conn.prepareStatement(sql);
//            stmt.setLong(1, id);
//            stmt.setInt(2, homeTeamId);
//            stmt.setInt(3, awayTeamId);
//
//            result = stmt.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //STEP 6: finally block used to close resources
//            try {
//                if (rs != null) rs.close();
//                if (stmt != null) stmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//    //method 3
//    // delete a game record
//    public int deleteGame(long id) {
//        List<Game> Game = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        int result = 0;
//
//        try {
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            //STEP 3: Execute a query
//            System.out.println("Creating statement...");
//            String sql = "DELETE FROM Games " + "WHERE id = ?";
//            stmt = conn.prepareStatement(sql);
//            stmt.setLong(1, id);
//
//            result = stmt.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //STEP 6: finally block used to close resources
//            try {
//                if (rs != null) rs.close();
//                if (stmt != null) stmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//    //method 4
//    //update game record
//
//    public int updateHomeGoals(long id, int homeGoals) {
//        List<Game> Game = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        int result = 0;
//
//        try {
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            //STEP 3: Execute a query
//            System.out.println("Creating statement...");
//            String sql = "UPDATE Games " + "SET home_goals = ? WHERE id =? ";
//            stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, homeGoals);
//            stmt.setLong(2, id);
//
//            result = stmt.executeUpdate();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //STEP 6: finally block used to close resources
//            try {
//                if (rs != null) rs.close();
//                if (stmt != null) stmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//
//
//    }
//}
