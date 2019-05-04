package com.example.depthon3hangshi.service.Impl;

import com.example.depthon3hangshi.domain.User;
import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.dto.UserLoginResponse;
import com.example.depthon3hangshi.dto.UserRequest;
import com.example.depthon3hangshi.exception.ExistUserException;
import com.example.depthon3hangshi.repository.UserRepository;
import com.example.depthon3hangshi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public ResponseDto<UserLoginResponse> createUser(UserRequest userRequest) {
        User user = User.of(userRequest);
        if(userRepository.findByName(userRequest.getName()).isPresent()){
            throw new ExistUserException();
        }

        userRepository.save(user);

        return ResponseDto.of(HttpStatus.OK,
                "success",
                UserLoginResponse.of(user.getId(), user.getName()));
    }
}
