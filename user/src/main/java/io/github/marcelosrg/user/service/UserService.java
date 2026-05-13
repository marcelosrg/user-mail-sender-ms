package io.github.marcelosrg.user.service;

import io.github.marcelosrg.user.domain.UserModel;
import io.github.marcelosrg.user.dto.UserDto;
import io.github.marcelosrg.user.producer.UserProducer;
import io.github.marcelosrg.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository,
                       UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel create(UserDto userDto) {

       var userModel = new UserModel();
       BeanUtils.copyProperties(userDto, userModel);
       userModel = userRepository.save(userModel);
       userProducer.publishEvent(userModel);

       return userModel;
    }

}
