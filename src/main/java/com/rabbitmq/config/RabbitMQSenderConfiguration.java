package com.rabbitmq.config;

import com.rabbitmq.annotations.Sender;
import com.rabbitmq.sender.RabbitMQSender;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Sender
@Configuration
public class RabbitMQSenderConfiguration {

    {
        System.out.println("Creating sending configuration.");
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        return factory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(){
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setExchange("test_exchange");
        return template;
    }

    @Bean(initMethod = "send")
    public RabbitMQSender sender() {
        return new RabbitMQSender();
    }
}
