package com.example.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    @Bean
    public TopicExchange topic() {
        return new TopicExchange("user.topic");
    }

    @Bean
    public MessageSender sender() {
        return new MessageSender();
    }

    @Bean
    public Queue autoDeletedQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding(TopicExchange topic, Queue autoDeletedQueue) {
        return BindingBuilder.bind(autoDeletedQueue).to(topic).with("create.user");
    }

    @Bean
    public Binding bindingSendUser(TopicExchange topic, Queue autoDeletedQueue) {
        return BindingBuilder.bind(autoDeletedQueue).to(topic).with("send.user");
    }

    @Bean
    public MessageReceiver receiver() {
        return new MessageReceiver();
    }

}
