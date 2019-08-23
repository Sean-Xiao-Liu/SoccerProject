package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
//            logger.info(String.format(">>>>>> Team: " + team.toString()));

            session.delete(team);
            transaction.commit();
            deletedCount = 1;
        }

        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.info(String.format("The team %s was deleted, total deleted record(s): %d", teamName, deletedCount));
        return deletedCount;
    }




    //method 4
    //list all teams
    @Override
    public List<Team> getTeams() {
//        String hql = "select distinct t FROM Team t LEFT join fetch t.players left join fetch t.homeGames left join fetch t.awayGames";// use select distinct to deal with duplicated data
//        String hql = "FROM Team t LEFT join fetch t.players left join fetch t.homeGames left join fetch t.awayGames";
        String hql = "FROM Team";
        //use select distinct to prevent duplicated row of team since the data are join fetched//
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Team> query = session.createQuery(hql);
//           return query.list();
            return query.list().stream().distinct().collect(Collectors.toList());
//            return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list(); // also works for duplicated data, remove "select distinct t" in hql when applied
        }
    }

    @Override
    public Team getTeamById(long id) {
//        String hql = "From Team t LEFT join fetch t.players left join fetch t.homeGames left join fetch t.awayGames where t.id = :id";
        String hql = "From Team t where t.id = :id";

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
        String hql = "FROM Team t LEFT join fetch t.players where t.id = :id";
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

//    @Override
//    public int updateTeam(Team team){
//        Transaction transaction = null;
//        boolean isSuccess = true;
//        int updateCount = 0;
//
//        try(Session session = HibernateUtil.getSessionFactory().openSession()){
////            Query<User> query = session.createQuery(hql);
//
//            transaction = session.beginTransaction();
//            session.saveOrUpdate(team);
////            updateCount = query.executeUpdate();
//            transaction.commit();
//        }
//        catch(Exception e){
//            isSuccess = false;
//            if(transaction != null) transaction.rollback();
//            logger.error(e.getMessage());
//        }
//
//        if(isSuccess) {
//            updateCount ++;
//            logger.debug(String.format("The team %s has been updated.",team.getTeamName()));
//        }
//        return updateCount;
//    }



    public static void main(String[] args) {

    }

}
