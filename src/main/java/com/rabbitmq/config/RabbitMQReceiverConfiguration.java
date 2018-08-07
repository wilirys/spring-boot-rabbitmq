package com.rabbitmq.config;

import com.rabbitmq.annotations.Receiver;
import com.rabbitmq.receiver.RabbitMQReceiver;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Receiver
public class RabbitMQReceiverConfiguration {

    {
        System.out.println("Creating receiving configuration.");
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        return factory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public Queue fruits() {
        return new Queue("fruits");
    }

    @Bean
    public Queue vegetables() {
        return new Queue("vegetables");
    }

    @Bean
    public RabbitMQReceiver receiver() {
        return new RabbitMQReceiver();
    }
}
