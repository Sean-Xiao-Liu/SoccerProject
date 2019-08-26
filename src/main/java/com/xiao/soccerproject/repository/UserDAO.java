package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.User;

public interface UserDAO {
    boolean save(User user);
    User getUserByEmail(String email);
    User getUserByCredentials(String email, String password);
}
