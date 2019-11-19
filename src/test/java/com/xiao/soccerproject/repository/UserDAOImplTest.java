package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.model.Role;
import com.xiao.soccerproject.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)

public class UserDAOImplTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Logger logger;

    public User userTestRecordOne;
    public User userTestRecordTwo;
    public Role role;


    @Before
    public void init(){
        userTestRecordOne = new User();
        userTestRecordOne.setName("User 1");
        userTestRecordOne.setFirstName("John");
        userTestRecordOne.setLastName("Cooper");
        userTestRecordOne.setPassword("zxcvbn");
        userTestRecordOne.setEmail("123@gmail.com");
        userDAO.save(userTestRecordOne);

        userTestRecordTwo = new User();
        userTestRecordTwo.setName("User 2");
        userTestRecordTwo.setFirstName("Mini");
        userTestRecordTwo.setLastName("Cooper");
        userTestRecordTwo.setPassword("asdfgh");
        userTestRecordTwo.setEmail("456@hotmail.com");
        userDAO.save(userTestRecordTwo);

    }

    @After
    public void cleanup(){
        userDAO.deleteUserById(userTestRecordOne.getId());
        userDAO.deleteUserByEmail(userTestRecordTwo.getEmail());
    }

    @Test
    public void getUserByEmailTest(){
        String email = userTestRecordOne.getEmail();
        logger.info(String.format("The user is %s",userTestRecordOne.getName()));
//        assertNotNull(userDAO.getUserByEmail(email));
        assertEquals(userDAO.getUserByEmail(email),userTestRecordOne);
    }

    @Test
    public void getUserByCredentialTest(){
        String email = userTestRecordTwo.getEmail();
        String password = userTestRecordTwo.getPassword();
        assertEquals(userDAO.getUserByCredentials(email,password),userTestRecordTwo);
    }

    @Test
    public void updateUserTest(){
        userTestRecordOne.setPassword("qwertt");
        int updateCount = userDAO.updateUser(userTestRecordOne);
        assertEquals(1,updateCount);
    }
}
