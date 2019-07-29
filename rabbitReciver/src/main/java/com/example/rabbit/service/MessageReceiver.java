package com.example.rabbit.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitHandler
    @RabbitListener(queues = "#{queueMessage.name}")
    public void receiveMessage(String message) {
        System.out.println("***********" + message + "************");
    }
}
