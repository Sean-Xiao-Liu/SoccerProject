package com.xiao.soccerproject.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.xiao.soccerproject.init.AppInitializer;
import org.junit.Ignore;
import org.junit.Test;
import com.xiao.soccerproject.init.AppInitializer;
import com.xiao.soccerproject.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)
public class MessageServiceTest {

    @Autowired
    private Logger logger;

    @Autowired
    private MessageService messageService;

    @Ignore
    @Test
    public void getQueueUrlTest(){
        String queueName = "soccer-project-queue";
        String result = messageService.getQueueUrl(queueName);
        assertEquals(69, result.length());
    }





}
