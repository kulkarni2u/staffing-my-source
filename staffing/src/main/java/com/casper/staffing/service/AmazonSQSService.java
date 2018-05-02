package com.casper.staffing.service;

import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.casper.staffing.exception.BaseServiceException;

import java.util.List;
import java.util.Map;

public interface AmazonSQSService {
    String sendMessage(String message) throws BaseServiceException;

    String sendMessage(String message, Map<String, MessageAttributeValue> messageAttributes) throws BaseServiceException;

    List<Message> receiveMessages(int numberOfMessages);

    DeleteMessageResult deleteMessage(Message message);

    Long getNumberOfMessages();
}
