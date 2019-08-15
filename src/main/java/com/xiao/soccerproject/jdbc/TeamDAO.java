//package com.xiao.soccerproject.jdbc;
//
//import com.xiao.soccerproject.model.Team;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TeamDAO { //same as the plug in fills
//    static final String DB_URL = "jdbc:postgresql://localhost:5431/SoccerProject_db";
//    static final String USER = "admin";
//    static final String PASS = "123456";
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    // method 1
//    // read database Team
//    public List<Team> getTeam() {
//        List<Team> Team = new ArrayList<>();
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
//            sql = "SELECT * FROM Teams";
//            rs = stmt.executeQuery(sql);
//            //STEP 4: Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column name!!!
//                String teamName = rs.getString("team_name");
//                long id = rs.getLong("id");
//                int homeWin = rs.getInt("home_win");
//                int awayWin = rs.getInt("away_win");
//
//                //Fill the object
//                Team teams = new Team();
//                teams.setTeamName(teamName);
//                teams.setId(id);
//                teams.setHomeWin(homeWin);
//                teams.setAwayWin(awayWin);
//                Team.add(teams);
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
//        return Team;
//    }
//
//    // method 2
//    // Update database Team
//    public int updateTeam(long id, int homeWin) {
//        List<Team> Team = new ArrayList<>();
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
//            String sql = "UPDATE Teams " + "SET home_win = ? WHERE id =? ";
//            stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, homeWin);
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
//    // method 3
//    // get info of 1 team
//    public Team getTeamInfo(int tId) {
//        Team team = new Team();
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//
//        try {
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            //STEP 3: Execute a query
//            System.out.println("Creating statement...");
//            String sql = "SELECT * FROM Teams WHERE id = ?";
//            stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, tId);
//            rs = stmt.executeQuery();
//            //STEP 4: Extract data from result set
//
//            while (rs.next()) {
//                //Retrieve by column name
//                String teamName = rs.getString("team_name");
//                long id = rs.getLong("id");
//                int homeWin = rs.getInt("home_win");
//                int awayWin = rs.getInt("away_win");
//
//                //Fill the object
//
//                team.setTeamName(teamName);
//                team.setId(id);
//                team.setHomeWin(homeWin);
//                team.setAwayWin(awayWin);
////                Team.add(teams);
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
//        return team;
//    }
//
//    //method 4
//    //delete records of certain team
//    public int deleteTeam(long id) {
//        List<Team> Team = new ArrayList<>();
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
//            String sql = "DELETE FROM Teams " + "WHERE id = ?";
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
//    // method 5
//    // insert record of team
//    public int insertTeam(String teamName,long id) {
//        List<Team> Team = new ArrayList<>();
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
//            String sql = "INSERT INTO Teams (team_name, id) " + "VALUES (? , ?)";
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, teamName);
//            stmt.setLong(2, id);
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
//    public static void main(String[] args) {
//    }
//
//
//}
