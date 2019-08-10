package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class HibernateMappingTest {

    @Test
    public void teamMappingTest(){
        String hql = "FROM Team";
        List<Team> teams = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Team> query = session.createQuery(hql);
            teams = query.list();
    }


    @Test
    public void playerMappingTest(){
        String hql = "FROM Player";
        List<Player> players = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Player> query = session.createQuery(hql);
        players = query.list();

    }

    @Test
    public void gameMappingTest(){
        String hql = "FROM Game";
        List<Game> games = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Game> query = session.createQuery(hql);
        games = query.list();

    }
}
