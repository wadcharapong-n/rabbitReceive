package com.example.rabbit.config.consumer;

import com.example.rabbit.service.MessageReceiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConsumerConfig {

    public final static String queueName = "send.user";
    public final static String exchangeName = "user.topic";

//    @Bean(name = "topicMessage")
//    TopicExchange topic() {
//        return new TopicExchange(exchangeName);
//    }

    @Bean(name = "queueMessage")
    public Queue queue() {
        return new AnonymousQueue();
    }

    @Bean(name = "binddingMessage")
    public Binding binding(TopicExchange topic, Queue queueMessage) {
        return BindingBuilder.bind(queueMessage).to(topic).with(queueName);
    }

    @Bean(name = "recevierMessage")
    public MessageReceiver receiver() {
        return new MessageReceiver();
    }

    @Bean(name = "listenerAdapterMessage")
    MessageListenerAdapter listenerAdapter(MessageReceiver recevierMessage) {
        return new MessageListenerAdapter(recevierMessage, "receiveMessage");
    }
}
