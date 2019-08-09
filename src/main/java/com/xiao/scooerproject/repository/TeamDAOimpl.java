package com.xiao.scooerproject.repository;

import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TeamDAOimpl implements TeamDAO{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean save(Team teams){
        Transaction transaction = null;
        boolean isSuccess = true;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(teams);
            transaction.commit();
        }

        catch(Exception e){
            isSuccess = false;
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess)  logger.debug(String.format("The team %s is saved"),teams);

        return isSuccess;
    }

    @Override
    public boolean update(Team teams){
        Transaction transaction = null;
        boolean isSuccess = true;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(teams);
            transaction.commit();
        }

        catch(Exception e){
            isSuccess = false;
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }


        return isSuccess;
    }

    @Override
    public boolean delete(String teamName) {
        String hql = "DELETE Team where teamName = :teamName";
        int deletedCount = 0;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Team> query = session.createQuery(hql);
            query.setParameter("teamName",teamName);

            transaction = session.beginTransaction();
            deletedCount = query.executeUpdate();
            transaction.commit();
        }

        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        return deletedCount >= 1 ? true:false; // Ternary operation
    }

    @Override
    public List<Team> getTeams() {
        String hql = "FROM Team";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Team> query = session.createQuery(hql);
            return query.list();
        }
    }

    @Override
    public Team getTeamById(String teamId) {
        if (teamId == null) return null;

        String hql = "FROM Team where lower(Team.teamId) = :teamId";

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Team> query = session.createQuery(hql);
            query.setParameter("teamId",teamId.toLowerCase());

            Team team = query.uniqueResult();
            logger.debug(team.toString());
            return team;
        }
    }

    public static void main(String[] args) {

    }
}
