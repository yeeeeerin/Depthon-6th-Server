package com.example.depthon3hangshi.controller;

import com.example.depthon3hangshi.dto.HangshiDto;
import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.dto.UserLoginResponse;
import com.example.depthon3hangshi.dto.UserRequest;
import com.example.depthon3hangshi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseDto<UserLoginResponse> CreateUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/user/{userId}/get_hangshi")
    public List<HangshiDto> getHangshi(@PathVariable("userId") Long userId,
                                       @RequestParam int page) {

        return userService.getHangshi(userId, page);
    }
}
