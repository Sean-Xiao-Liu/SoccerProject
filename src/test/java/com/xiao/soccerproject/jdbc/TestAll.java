package com.xiao.soccerproject.jdbc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                PlayerDAOTest.class,
                GameDAOTest.class,
                TeamDAOTest.class
        }
)

public class TestAll {
}
