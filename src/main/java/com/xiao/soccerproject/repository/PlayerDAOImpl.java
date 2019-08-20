package com.xiao.soccerproject.repository;

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
public class PlayerDAOImpl implements PlayerDAO{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //method 1
    //insert a new record of player
    @Override
    public boolean save(Player player, Team teams){
        Transaction transaction = null;
        boolean isSuccess = true;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            //players.getTeam(teams);
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
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Player> query = session.createQuery(hql);
            return query.list();
        }
    }

    //method 3
    //update player age by id
    @Override
    public int updatePlayerAge(long id, int age){
        String hql = "UPDATE Player as p set p.age = :age WHERE p.id = :id";
        int updatedCount = 0;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Player> query = session.createQuery(hql);
            query.setParameter("age", age);
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

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
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

    //method 5
    //get record of a player
    @Override
    public Player getPlayerById(long id) {
        String hql = "FROM Player p where p.id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Player> query = session.createQuery(hql);
            query.setParameter("id",id);

            Player player = query.uniqueResult();
            logger.info(player.toString());
            return query.uniqueResult();

        }
    }

    @Override
    public Player getPlayerByName(String playerName){
            String hql = "From Player as p where p.playerName = :name";

            try (Session session = HibernateUtil.getSessionFactory().openSession()){
                Query<Player> query = session.createQuery(hql);
                query.setParameter("name",playerName);

                Player player = query.uniqueResult();
                logger.info(player.toString());
                return query.uniqueResult();

            }

    }

    public static void main(String[] args) {

    }
}
