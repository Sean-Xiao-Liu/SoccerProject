package com.xiao.soccerproject.service;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    private Logger logger;

    @Autowired
    private AmazonSQS amazonSQS;

    public String createQueue(String queueName){
        String queueUrl = null;

        try{
            queueUrl = getQueueUrl(queueName);
        } catch (QueueDoesNotExistException e){
            CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
            queueUrl = amazonSQS.createQueue(createQueueRequest).getQueueUrl();
        }
        return queueUrl;
    }

    public String getQueueUrl(String queueName){
        return amazonSQS.getQueueUrl(queueName).getQueueUrl();
    }

    public List listQueue(){
        List list = new ArrayList();
        try{
            ListQueuesResult listQueuesResult = amazonSQS.listQueues();
            list = listQueuesResult.getQueueUrls();
        } catch (Exception e){
            list = null;
            logger.info("There is no Queue to be listed");
        }
        return list;
    }

    public void deleteQueue(String queueName){
        try{
            amazonSQS.deleteQueue(queueName);
        } catch (QueueDoesNotExistException e){
            logger.info(String.format("This queue %s does not exist", queueName));
        }
    }

    public void sendMessage(String queueName, String msg) {
        Map<String, MessageAttributeValue> messageAttributes = new HashMap();
        MessageAttributeValue messageAttributeValue = new MessageAttributeValue();
        messageAttributeValue.withDataType("String").withStringValue("File URL in S3");
        messageAttributes.put("message", messageAttributeValue);
        String queueUrl = getQueueUrl(queueName);
        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.withQueueUrl(queueUrl)
                .withMessageBody(msg)
                .withMessageAttributes(messageAttributes);
        amazonSQS.sendMessage(sendMessageRequest);
    }
    public List<Message> getMessages(String queueName) {
        String queueUrl = getQueueUrl(queueName);
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
        List<Message> messages = amazonSQS.receiveMessage(receiveMessageRequest).getMessages();
        return messages;
    }

    public void deleteMessage(String queueName, String message){
        try{
            amazonSQS.deleteMessage(queueName,message);
        } catch (Exception e){
            logger.info(String.format("There is something wrong with the queue '%s' or the message '%s'.",queueName,message));
        }
    }
}
