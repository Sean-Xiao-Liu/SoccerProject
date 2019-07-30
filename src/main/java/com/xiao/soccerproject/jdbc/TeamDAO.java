package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO { //same as the plug in fills
    static final String DB_URL = "jdbc:postgresql://localhost:5431/SoccerProject_db";
    static final String USER = "admin";
    static final String PASS = "123456";

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
                //Retrieve by column name
                String teamname = rs.getString("teamname");
                String teamid = rs.getString("teamid");
                int homewin = rs.getInt("homewin");
                int awaywin = rs.getInt("awaywin");

                //Fill the object
                Team teams = new Team();
                teams.setTeamname(teamname);
                teams.setTeamid(teamid);
                teams.setHomewin(homewin);
                teams.setAwaywin(awaywin);
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
            String sql = "UPDATE Team " + "SET homewin = ? WHERE teamid =? ";
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
            String sql = "SELECT * FROM Team WHERE teamid = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tId);
            rs = stmt.executeQuery();
            //STEP 4: Extract data from result set

            while (rs.next()) {
                //Retrieve by column name
                String teamName = rs.getString("teamname");
                String teamId = rs.getString("teamid");
                int homeWin = rs.getInt("homewin");
                int awayWin = rs.getInt("awaywin");

                //Fill the object

                team.setTeamname(teamName);
                team.setTeamid(teamId);
                team.setHomewin(homeWin);
                team.setAwaywin(awayWin);
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


    public static void main(String[] args) {
    }


}
