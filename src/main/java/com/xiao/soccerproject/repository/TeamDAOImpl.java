package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //method 1
    // save team info
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

        if (isSuccess)  logger.info("the team is saved");

        return isSuccess;
    }

    //method 2
    //update the home win numbers of a team
    @Override
    public int updateTeamHomeWin(long id, int homeWin){
        String hql = "UPDATE Team as t set t.homeWin = :homeWin WHERE t.id = :id";
        int updatedCount = 0;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Team> query = session.createQuery(hql);
            query.setParameter("homeWin", homeWin);
            query.setParameter("id",id);

            transaction = session.beginTransaction();
            updatedCount = query.executeUpdate();
//            session.saveOrUpdate(teams);
            transaction.commit();
        }

        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.info(String.format("The team %s was updated, total updated record(s): %d", id, updatedCount));
        return updatedCount;
    }

    //method 3
    //delete a team
    @Override
    public int deleteById(long id) {
        String hql = "DELETE Team t WHERE t.id = :id";
        int deletedCount = 0;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Team> query = session.createQuery(hql);
            query.setParameter("id",id);

            transaction = session.beginTransaction();
            deletedCount = query.executeUpdate();
            transaction.commit();
        }

        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.info(String.format("The team %s was deleted, total deleted record(s): %d", id, deletedCount));
        return deletedCount;
    }

    @Override
    public int deleteTeamByName(String teamName){
        int deletedCount = 0;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();// use getCurrentSession instead of OpenSession, don't need close session manually.
            transaction = session.beginTransaction();

            Team team = getTeamByName(teamName);
            session.delete(team);
            transaction.commit(); 
            deletedCount = 1;
        }

        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
//        logger.info(String.format("The team %s was deleted, total deleted record(s): %d", teamName, deletedCount));
        return deletedCount;
    }




    //method 4
    //list all teams
    @Override
    public List<Team> getTeams() {
        String hql = "FROM Team";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Team> query = session.createQuery(hql);
            return query.list();
        }
    }

    @Override
    public Team getTeamById(long id) {
//        String hql = "FROM Team t where t.id = :id ";
        String hql = "From Team t left join fetch t.homeGames where t.id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Team> query = session.createQuery(hql);
            query.setParameter("id",id);

            Team team = query.uniqueResult();
            logger.info(team.toString());
            return query.uniqueResult();

        }
    }

    @Override
    public Team getTeamByName(String teamName){
        String hql = "From Team as t where t.teamName = :name";

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Team> query = session.createQuery(hql);
            query.setParameter("name",teamName);

            Team team = query.uniqueResult();
            logger.info(team.toString());
            return query.uniqueResult();

        }
    }

    @Override
    public List<Player> getPlayersByTeamId(long id) {
        String hql = "FROM Team t left join fetch t.players where t.id = :id";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Player> query = session.createQuery(hql);
            query.setParameter("id", id);
            return query.list();
        }
    }
//
//    @Override
//    public List<Game> getGamesByHomeTeamId(long id) {
//        String hql = "FROM Team t join fetch t.homeGames where t.id = :id";
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Query<Game> query = session.createQuery(hql);
//            query.setParameter("id", id);
//            return query.list();
//        }
//    }



    public static void main(String[] args) {

    }

}
