package com.xiao.soccerproject.service;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                PlayerServiceTest.class,
                GameServiceTest.class,
                TeamServiceTest.class,
                FileServiceTest.class
        }
)
public class ServiceTestAll {
}
