package io.github.marcelosrg.user.producer;

import io.github.marcelosrg.user.domain.UserModel;

import io.github.marcelosrg.user.dto.EmailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String rountingKey = "email-queue";


    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendUserCreatedEvent(UserModel userModel) {

        var emailDto = new EmailDto(
                userModel.getId(),
                userModel.getEmail(),
                "Bem vindo a Plataforma Verbum",
                "Ola "
        );

       rabbitTemplate.convertAndSend("",rountingKey, emailDto);

    }
}
