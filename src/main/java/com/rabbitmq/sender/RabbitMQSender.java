package com.rabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        this.rabbitTemplate.convertAndSend("fruits", "Orange");
        this.rabbitTemplate.convertAndSend("fruits", "Apple");
        this.rabbitTemplate.convertAndSend("fruits", "Banana");

        this.rabbitTemplate.convertAndSend("vegetables", "Tomato");
        this.rabbitTemplate.convertAndSend("vegetables", "Potato");
        this.rabbitTemplate.convertAndSend("vegetables", "Cucumber");
    }
}
