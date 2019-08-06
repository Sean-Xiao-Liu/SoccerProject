package com.xiao.soccerproject.repository;

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
//        try(
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Team> query = session.createQuery(hql);
            teams = query.list();
//        }
//        catch
    }


    @Test
    public void playerMappingTest(){
        String hql = "FROM Player";
        List<Team> teams = null;
//        try(
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Team> query = session.createQuery(hql);
        teams = query.list();
//        }
//        catch
    }
}
