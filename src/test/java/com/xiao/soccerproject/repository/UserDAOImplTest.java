package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.User;
import org.junit.Before;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class UserDAOImplTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Logger logger;

    public User userTestRecordOne;
    public User userTestRecordTwo;

    @Before
    public void init(){
        userTestRecordOne = new User();

    }

}
