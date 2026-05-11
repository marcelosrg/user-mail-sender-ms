package io.github.marcelosrg.user.controller;

import io.github.marcelosrg.user.domain.UserModel;
import io.github.marcelosrg.user.dto.UserDto;
import io.github.marcelosrg.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users/")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserModel> create(@RequestBody UserDto userDto) {
        UserModel user = userService.create(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
