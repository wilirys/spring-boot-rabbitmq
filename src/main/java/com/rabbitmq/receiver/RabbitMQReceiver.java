package com.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues={"fruits", "vegetables"})
public class RabbitMQReceiver {

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Receive '"+in+"'");
    }
}
