package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.User;

import java.util.List;

public interface UserDAO {
    boolean save(User user);
    User getUserByEmail(String email);
    User getUserByCredentials(String email, String password);
    List<User> getUsers();
    int updateUser(User user);
    int deleteUserById(long id);
    int deleteUserByEmail(String email);

}
