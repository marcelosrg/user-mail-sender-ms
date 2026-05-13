package io.github.marcelosrg.email.consumer;

import io.github.marcelosrg.email.dto.EmailDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "email-queue")
    public void consumeEmailQueue(@Payload EmailDto emailDto) {
        System.out.println(emailDto.emailTo());
    }
}
