package com.example.rabbit.service;

import com.example.rabbit.model.UserProfile;
import com.example.rabbit.repository.UserRepository;
import com.example.rabbit.util.CustomObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileReceiver {
    @Autowired
    UserRepository userRepository;

    @RabbitHandler
    @RabbitListener(queues = "#{autoDeletedQueue.name}")
    public void receive(String userString) {
        System.out.println(userString);
        try {
            CustomObjectMapper mapper = new CustomObjectMapper();
            UserProfile userProfile = mapper.readValue(userString, UserProfile.class);
            userRepository.insert(userProfile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}