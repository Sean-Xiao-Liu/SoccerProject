package com.xiao.soccerproject.service;

import com.xiao.soccerproject.model.User;
import com.xiao.soccerproject.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean save(User user) {
        return userDAO.save(user);
    }
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
    public User getUserByCredentials(String email, String password) {
        return userDAO.getUserByCredentials(email, password);
    }

    public List<User> getUsers(){
        return userDAO.getUsers();
    }

    public int updateUser(User user){
        return userDAO.updateUser(user);
    }

    public int deleteUserById(long id){
        return userDAO.deleteUserById(id);
    }

    public int deleteUserByEmail(String email){
        return userDAO.deleteUserByEmail(email);
    }
}
