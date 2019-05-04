package com.example.depthon3hangshi.service.Impl;

import com.example.depthon3hangshi.domain.User;
import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.dto.UserRequest;
import com.example.depthon3hangshi.repository.UserRepository;
import com.example.depthon3hangshi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseDto createUser(UserRequest userRequest) {
        User user = User.of(userRequest);
        if(userRepository.findByName(userRequest.getName()).isPresent()){
            return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, "have user");
        }
        userRepository.save(user);

        return ResponseDto.of(HttpStatus.OK,"success");
    }
}
