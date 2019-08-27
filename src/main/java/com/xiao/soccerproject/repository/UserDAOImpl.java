package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.User;
import com.xiao.soccerproject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAOImpl implements UserDAO{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean save(User user) {
        Transaction transaction = null;
        boolean isSuccess = true;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        if (isSuccess) logger.debug(String.format("The user %s was inserted into the table.", user.toString()));
        return isSuccess;
    }

    @Override
    public User getUserByEmail(String email) {
        String hql = "FROM User as u where lower(u.email) = :email";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(hql);
            query.setParameter("email", email.toLowerCase());
            return query.uniqueResult();
        }
    }
    @Override
    public User getUserByCredentials(String email, String password) {
        String hql = "FROM User as u where lower(u.email) = :email and u.password = :password";
        logger.debug(String.format("User email: %s, password: %s", email, password));
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(hql);
            query.setParameter("email", email.toLowerCase().trim());
            query.setParameter("password", password);
            return query.uniqueResult();
        }
    }

    @Override
    public List<User> getUsers(){
        String hql = "FROM User";
        //use select distinct to prevent duplicated row of team since the data are join fetched//
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(hql);
            return query.list().stream().distinct().collect(Collectors.toList());
        }
    }

    @Override
    public int updateUser(User user){
        Transaction transaction = null;
        boolean isSuccess = true;
        int updateCount = 0;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        }
        catch(Exception e){
            isSuccess = false;
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if(isSuccess) {
            updateCount ++;
            logger.debug(String.format("The user %s has been updated.",user.getName()));
        }
        return updateCount;
    }

    @Override
    public int deleteUserById(long id){
        String hql = "DELETE User u WHERE u.id = :id";
        int deletedCount = 0;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<User> query = session.createQuery(hql);
            query.setParameter("id",id);

            transaction = session.beginTransaction();
            deletedCount = query.executeUpdate();
            transaction.commit();
        }

        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.info(String.format("The user %s was deleted, total deleted record(s): %d", id, deletedCount));
        return deletedCount;
    }

    @Override
    public int deleteUserByEmail(String email){
        int deletedCount = 0;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();// use getCurrentSession instead of OpenSession, don't need close session manually.
            transaction = session.beginTransaction();
            User user = getUserByEmail(email);

            session.delete(user);
            transaction.commit();
            deletedCount = 1;
        }

        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.info(String.format("The user with email %s was deleted, total deleted record(s): %d", email, deletedCount));
        return deletedCount;
    }



}
