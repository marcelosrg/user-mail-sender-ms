package io.github.marcelosrg.user.service;

import io.github.marcelosrg.user.domain.UserModel;
import io.github.marcelosrg.user.dto.UserDto;
import io.github.marcelosrg.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel create(UserDto userDto) {

        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
       return userModel = userRepository.save(userModel);
    }

}
