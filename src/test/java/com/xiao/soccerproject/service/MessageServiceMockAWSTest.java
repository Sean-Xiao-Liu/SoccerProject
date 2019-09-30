package com.xiao.soccerproject.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import com.xiao.soccerproject.init.AppInitializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)
public class MessageServiceMockAWSTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS) private AmazonSQS amazonSQS;

    @Autowired @Spy private Logger logger;

    @InjectMocks private MessageService messageService;

    private String queueName = "mockTestQueue";
    private String fakeQueueUrl = "http://www.fakeQueueUrl.com/xiao/soccerproject/fake";
    private String messages = "queue test message";
    private ListQueuesResult listQueuesResult = new ListQueuesResult();
    private List<Message> list = new ArrayList<>();

    @Before
    public void setUP() throws IOException, MalformedParameterizedTypeException, FileNotFoundException {
        logger.info(">>>>>>>>>>>>>>>>>>>test start<<<<<<<<<<<<<<<<<");

        //initial Mocks
        MockitoAnnotations.initMocks(this);

        //Stubbing method of SQS
        when(amazonSQS.createQueue(any(CreateQueueRequest.class)).getQueueUrl()).thenReturn(fakeQueueUrl);// determine the properties type based on the method input requirement
        when(amazonSQS.getQueueUrl(anyString()).getQueueUrl()).thenReturn(fakeQueueUrl);// is tested in the get queue Url test
        when(amazonSQS.receiveMessage(any(ReceiveMessageRequest.class)).getMessages()).thenReturn(list);
    }

    @After
    public void tearDown(){
        logger.info(">>>>>>>>>>>>>>>>>>>test end<<<<<<<<<<<<<<<<<<<");
    }


    @Test
    public void createQueueTest(){
        when(amazonSQS.getQueueUrl(queueName).getQueueUrl()).thenThrow(new QueueDoesNotExistException("This queue does not exist"));// exception should be written within test
        messageService.createQueue(queueName);
        verify(amazonSQS,times(1)).createQueue(any(CreateQueueRequest.class));
    }

    @Test
    public void getQueueUrlTest(){
        verify(amazonSQS,times(1)).getQueueUrl(anyString()); // stubbed in @Before
    }

    @Test
    public void listQueueTest(){
        when(amazonSQS.listQueues()).thenReturn(listQueuesResult);
        messageService.listQueue();
        verify(amazonSQS,times(1)).listQueues();//list queue does not need input
    }

    @Test
    public void deleteQueueTest(){
        messageService.deleteQueue(queueName);
        verify(amazonSQS,times(1)).deleteQueue(anyString());
    }

    @Test
    public void getMessagesTest(){
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest();
        when(amazonSQS.receiveMessage(receiveMessageRequest).getMessages()).thenReturn(list);
        messageService.getMessages(queueName);
        verify(amazonSQS,times(1)).receiveMessage(receiveMessageRequest);
    }

}
