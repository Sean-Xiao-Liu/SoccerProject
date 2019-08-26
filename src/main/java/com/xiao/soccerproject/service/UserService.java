package com.xiao.soccerproject.service;

import com.xiao.soccerproject.model.User;
import com.xiao.soccerproject.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
