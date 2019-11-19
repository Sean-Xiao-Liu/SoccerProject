package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.model.Player;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.service.TeamService;
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
public class PlayerDAOImpl implements PlayerDAO{
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Logger logger;

    @Autowired
    TeamDAO teamDAOImpl;

    //method 1
    //insert a new record of player
    @Override
    public boolean save(Player player, long teamId){
        Transaction transaction = null;
        boolean isSuccess = true;

        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Team team =  teamDAOImpl.getTeamById(teamId);
            player.setTeam(team);
            session.save(player);
            transaction.commit();
        }

        catch(Exception e){
            isSuccess = false;
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess)  logger.info("the player is saved");

        return isSuccess;
    }

    //method 2
    //list all players
    @Override
    public List<Player> getPlayers() {
        String hql = "FROM Player";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Query<Player> query = session.createQuery(hql);
            return query.list();
        } finally {
            session.close();
        }
    }

    //method 3
    //update player age by id
    @Override
    public int updatePlayerAge(long id, int age){
        String hql = "UPDATE Player as p set p.age = :age WHERE p.id = :id";
        int updatedCount = 0;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{

            Query<Player> query = session.createQuery(hql);
            query.setParameter("age", age);
            query.setParameter("id",id);

            transaction = session.beginTransaction();
            updatedCount = query.executeUpdate();
            transaction.commit();
        }

        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
        logger.info(String.format("The player %s was updated, total updated record(s): %d", id, updatedCount));
        return updatedCount;
    }



    @Override
    //method 4
    //delete a record of player
    public int deleteById(long id){
        String hql = "DELETE Player p WHERE p.id = :id";
        int deletedCount = 0;
        Transaction transaction = null;

        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Query<Player> query = session.createQuery(hql);
            query.setParameter("id",id);

            transaction = session.beginTransaction();
            deletedCount = query.executeUpdate();
            transaction.commit();
        }

        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.info(String.format("The player %s was deleted, total deleted record(s): %d", id, deletedCount));
        return deletedCount;
    }

    @Override
    public int deletePlayerByName(String playerName){
        int deletedCount = 0;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();// use getCurrentSession instead of OpenSession, don't need close session manually.
            transaction = session.beginTransaction();

            Player player = getPlayerByName(playerName);
            session.delete(player);
            transaction.commit();
            deletedCount = 1;
        }

        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.info(String.format("The player %s was deleted, total deleted record(s): %d", playerName, deletedCount));
        return deletedCount;
    }


    //method 5
    //get record of a player
    @Override
    public Player getPlayerById(long id) {
        String hql = "FROM Player p where p.id = :id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Player> query = session.createQuery(hql);
            query.setParameter("id",id);

            Player player = query.uniqueResult();
            logger.info(player.toString());
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public Player getPlayerByName(String name){
            String hql = "From Player as p where p.playerName = :name";
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                Query<Player> query = session.createQuery(hql);
                query.setParameter("name",name);

                Player player = query.uniqueResult();
//                logger.info(player.toString());
                return query.uniqueResult();
            } finally {
                session.close();
            }

    }

    @Override
    public int updatePlayer(Player player,long teamId){
        Transaction transaction = null;
        boolean isSuccess = true;
        int updateCount = 0;

        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            // set team_id foreign key//
            Team team =  teamDAOImpl.getTeamById(teamId);
            player.setTeam(team);

            session.saveOrUpdate(player);
            transaction.commit();
        }
        catch(Exception e){
            isSuccess = false;
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if(isSuccess) {
            updateCount ++;
            logger.debug("The player has been updated");
        }
        return updateCount;
    }

    public static void main(String[] args) {

    }
}
