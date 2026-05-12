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

    public void publishEvent(UserModel userModel) {

        String emailSubject ="Usuario Criado com sucesso!";
        String emailBody = "Hello" + userModel.getName() + ",\n\n Seja bem vindo ao Verbum";

        var emailDto = new EmailDto(
                userModel.getId(),
                userModel.getEmail(),
                emailSubject,
                emailBody
        );

       rabbitTemplate.convertAndSend("",rountingKey, emailDto);

    }
}
