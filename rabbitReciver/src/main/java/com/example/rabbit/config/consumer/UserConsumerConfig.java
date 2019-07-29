package com.example.rabbit.config.consumer;

import com.example.rabbit.service.UserProfileReceiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConsumerConfig {

    public final static String queueName = "create.user";
    public final static String exchangeName = "user.topic";

    @Bean
    public TopicExchange topic() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue autoDeletedQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding(TopicExchange topic, Queue autoDeletedQueue) {
        return BindingBuilder.bind(autoDeletedQueue).to(topic).with(queueName);
    }

    @Bean
    public UserProfileReceiver receiver() {
        return new UserProfileReceiver();
    }

//    @Bean
//    MessageListenerAdapter listenerAdapter(UserProfileReceiver receiver) {
//        return new MessageListenerAdapter(receiver);
//    }


}
