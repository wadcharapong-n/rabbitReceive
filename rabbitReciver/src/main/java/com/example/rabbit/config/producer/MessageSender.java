package com.example.rabbit.config.producer;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

//public class MessageSender {
//    @Autowired
//    private TopicExchange topic;
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void addUser(UserProfile customer) {
//        String key = "create.user";
//        rabbitTemplate.convertAndSend(topic.getName(), key, customer);
//    }
//
//}