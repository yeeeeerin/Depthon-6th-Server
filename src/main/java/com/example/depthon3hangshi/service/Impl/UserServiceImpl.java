package com.example.depthon3hangshi.service.Impl;

import com.example.depthon3hangshi.domain.User;
import com.example.depthon3hangshi.dto.HangshiDto;
import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.dto.UserLoginResponse;
import com.example.depthon3hangshi.dto.UserRequest;
import com.example.depthon3hangshi.exception.ExistUserException;
import com.example.depthon3hangshi.exception.NotFoundUserException;
import com.example.depthon3hangshi.repository.LikeHangshiRepository;
import com.example.depthon3hangshi.repository.UserRepository;
import com.example.depthon3hangshi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LikeHangshiRepository likeRepository;

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


    @Transactional(readOnly = true)
    public List<HangshiDto> getHangshi(Long userId, int page) {
        Pageable pageable = PageRequest.of(page, 20);
        User user = userRepository.findById(userId).orElseThrow(NotFoundUserException::new);
        return user.getHangshiSet().stream().map(hangshi -> {
            boolean like = false;
            if (likeRepository.findByHangshiAndUser(hangshi, user).isPresent()) {
                like = true;
            }
            return HangshiDto.of(hangshi, like);
        }).collect(Collectors.toList());
    }
}
