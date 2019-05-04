package com.example.depthon3hangshi.service;

import com.example.depthon3hangshi.dto.HangshiDto;
import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.dto.UserRequest;

import java.util.List;

public interface UserService {

    ResponseDto createUser(UserRequest userRequest);

    List<HangshiDto> getHangshi(Long userId, int page);

}
