package com.example.depthon3hangshi.service;

import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.dto.UserRequest;

public interface UserService {

    ResponseDto createUser(UserRequest userRequest);

}
