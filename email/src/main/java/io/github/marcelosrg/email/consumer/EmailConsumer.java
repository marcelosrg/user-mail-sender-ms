package io.github.marcelosrg.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "email-queue")
    public void consumeEmailQueue(@Payload String payload){
        System.out.println(payload);
    }
}
