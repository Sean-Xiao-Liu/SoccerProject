package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppInitializer.class)
@Repository
public class GameDAOImpl implements GameDAO{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TeamDAOImpl teamDAOImpl;

    @Override
    //method 1
    //save a game record
    public boolean save(Game games,long homeTeamId, long awayTeamId){
        Transaction transaction = null;
        boolean isSuccess = true;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            TeamDAOImpl teamDAOImpl = new TeamDAOImpl();
            Team homeTeam = teamDAOImpl.getTeamById(homeTeamId);
            Team awayTeam = teamDAOImpl.getTeamById(awayTeamId);
            games.setHomeTeam(homeTeam);
            games.setAwayTeam(awayTeam);
            session.save(games);
            transaction.commit();
        }

        catch(Exception e){
            isSuccess = false;
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess)  logger.info("the game record is saved");

        return isSuccess;
    }

    @Override
    public int updateHomeGoals(long id, int homeGoals){
        String hql = "UPDATE Game as g set g.homeGoals = :homeGoals WHERE g.id = :id";
        int updatedCount = 0;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Game> query = session.createQuery(hql);
            query.setParameter("homeGoals", homeGoals);
            query.setParameter("id",id);

            transaction = session.beginTransaction();
            updatedCount = query.executeUpdate();
//            session.saveOrUpdate(Game);
            transaction.commit();
        }

        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.info(String.format("The home goal number of %s was updated, total updated record(s): %d", id, updatedCount));
        return updatedCount;
    }

    //method 3
    //list all Games
    @Override
    public List<Game> getGames() {
        String hql = "FROM Game";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Game> query = session.createQuery(hql);
            return query.list();
        }
    }

    @Override
    public int deleteById(long id){
        String hql = "DELETE Game g WHERE g.id = :id";
        int deletedCount = 0;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Game> query = session.createQuery(hql);
            query.setParameter("id",id);

            transaction = session.beginTransaction();
            deletedCount = query.executeUpdate();
            transaction.commit();
        }

        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.info(String.format("The game record %s was deleted, total deleted record(s): %d", id, deletedCount));
        return deletedCount;
    }

    public Game getGameById(long id){
        String hql = "FROM Game g where g.id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Game> query = session.createQuery(hql);
            query.setParameter("id",id);

            Game game = query.uniqueResult();
            logger.info(game.toString());
            return query.uniqueResult();

        }
    }

    public static void main(String[] args) {

    }
}
