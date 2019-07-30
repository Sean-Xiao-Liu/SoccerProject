package com.xiao.soccerproject.jdbc;

import com.xiao.soccerproject.model.Matches;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MatchesDAO {
    static final String DB_URL = "jdbc:postgresql://localhost:5431/SoccerProject_db";
    static final String USER = "admin";
    static final String PASS = "123456";
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //method 1
    //read all content in the table
    public List<Matches> getMatches(){
        List<Matches> Matches = new ArrayList<>();
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
            sql = "SELECT * FROM Matches";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                String matchId = rs.getString("matchid");
                String teamId = rs.getString("teamid");
                String matchResult = rs.getString("matchresult");

                Matches mat = new Matches();
                mat.setMatchid(matchId);
                mat.setTeamid(teamId);
                mat.setMatchresult(matchResult);
                Matches.add(mat);
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
        return Matches; // this Matches is defined by :  List<Matches> Matches = new ArrayList<>();
    }

    public static void main(String[] args) {


    }
}
