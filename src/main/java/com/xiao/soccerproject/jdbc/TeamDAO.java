package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO { //same as the plug in fills
    static final String DB_URL = "jdbc:postgresql://localhost:5431/SoccerProject_db";
    static final String USER = "admin";
    static final String PASS = "123456";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // method 1
    // read database Team
    public List<Team> getTeam() {
        List<Team> Team = new ArrayList<>();
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
            sql = "SELECT * FROM Team";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name!!!
                String teamName = rs.getString("team_name");
                String teamId = rs.getString("team_id");
                int homeWin = rs.getInt("home_win");
                int awayWin = rs.getInt("away_win");

                //Fill the object
                Team teams = new Team();
                teams.setTeamName(teamName);
                teams.setTeamId(teamId);
                teams.setHomeWin(homeWin);
                teams.setAwayWin(awayWin);
                Team.add(teams);
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
        return Team;
    }

    // method 2
    // Update database Team
    public int updateTeam(String teamId, int homeWin) {
        List<Team> Team = new ArrayList<>();
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
            String sql = "UPDATE Team " + "SET home_win = ? WHERE team_id =? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, homeWin);
            stmt.setString(2, teamId);

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
    // get info of 1 team
    public Team getTeamInfo(String tId) {
        Team team = new Team();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM Team WHERE team_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tId);
            rs = stmt.executeQuery();
            //STEP 4: Extract data from result set

            while (rs.next()) {
                //Retrieve by column name
                String teamName = rs.getString("team_name");
                String teamId = rs.getString("team_id");
                int homeWin = rs.getInt("home_win");
                int awayWin = rs.getInt("away_win");

                //Fill the object

                team.setTeamName(teamName);
                team.setTeamId(teamId);
                team.setHomeWin(homeWin);
                team.setAwayWin(awayWin);
//                Team.add(teams);
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
        return team;
    }

    //method 4
    //delete records of certain team
    public int deleteTeam(String teamId) {
        List<Team> Team = new ArrayList<>();
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
            String sql = "DELETE FROM Team " + "WHERE team_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, teamId);

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

    // method 5
    // insert record of team
    public int insertTeam(String teamName,String teamId) {
        List<Team> Team = new ArrayList<>();
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
            String sql = "INSERT INTO Team (team_name, team_id) " + "VALUES (? , ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, teamName);
            stmt.setString(2, teamId);

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
