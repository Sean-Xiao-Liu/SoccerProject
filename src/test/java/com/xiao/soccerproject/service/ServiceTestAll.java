package com.xiao.soccerproject.service;

import com.xiao.soccerproject.repository.GameDAOImplTest;
import com.xiao.soccerproject.repository.PlayerDAOImplTest;
import com.xiao.soccerproject.repository.TeamDAOImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                PlayerServiceTest.class,
                GameServiceTest.class,
                TeamServiceTest.class
        }
)

public class ServiceTestAll {
}
