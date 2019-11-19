package com.xiao.soccerproject.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                PlayerDAOImplTest.class,
                GameDAOImplTest.class,
                TeamDAOImplTest.class,
                UserDAOImplTest.class
        }
)

public class DAOImplTestAll {
}
