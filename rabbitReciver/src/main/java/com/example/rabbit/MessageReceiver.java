package com.example.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageReceiver {
    @Autowired
    UserRepository userRepository;

    @RabbitHandler
    @RabbitListener(queues = "#{autoDeletedQueue.name}")
    public void receiveUserProfile(UserProfile userProfile) {
        System.out.println(userProfile);
        userRepository.insert(userProfile);
    }

//    @RabbitHandler
//    @RabbitListener(queues = "#{autoDeletedQueue.name}")
//    public void receiveMessage(String message) {
//        System.out.println("***********" + message + "************");
//    }


}