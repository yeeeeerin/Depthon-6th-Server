package com.example.depthon3hangshi.controller;

import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.dto.UserLoginResponse;
import com.example.depthon3hangshi.dto.UserRequest;
import com.example.depthon3hangshi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseDto<UserLoginResponse> CreateUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }
}
