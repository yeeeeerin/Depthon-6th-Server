package com.example.depthon3hangshi.service.Impl;

import com.example.depthon3hangshi.domain.Hangshi;
import com.example.depthon3hangshi.domain.LikeHangshi;
import com.example.depthon3hangshi.domain.WordCollector;
import com.example.depthon3hangshi.dto.HangshiRequest;
import com.example.depthon3hangshi.dto.HangshiResponse;
import com.example.depthon3hangshi.dto.LikeRequest;
import com.example.depthon3hangshi.repository.HangshiRepository;
import com.example.depthon3hangshi.repository.LikeHangshiRepository;
import com.example.depthon3hangshi.repository.UserRepository;
import com.example.depthon3hangshi.service.HangshiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HangshiServiceImpl implements HangshiService {

    private final HangshiRepository hangshiRepository;
    private final UserRepository userRepository;
    private final LikeHangshiRepository likeRepository;


    @Override
    @Transactional
    public HangshiResponse createQuestion() {
        HangshiResponse hangshiResponece = new HangshiResponse();
        hangshiResponece.setHangshi(WordCollector.getRandom());
        return hangshiResponece;
    }

    @Override
    @Transactional
    public void saveHangshi(HangshiRequest hangshiRequest) {

        userRepository.findByName(hangshiRequest.getUsername())
                .ifPresent(user -> {
                    Hangshi hangshi = Hangshi.of(hangshiRequest,user);
                    hangshiRepository.save(hangshi);
                });

    }


    @Override
    @Transactional
    public void likeHangshi(LikeRequest likeRequest) {

        hangshiRepository.findById(likeRequest.getHangshiId()).ifPresent(
                hangshi -> {
                    userRepository.findById(likeRequest.getUserId()).ifPresent(user -> {
                        LikeHangshi likeHangshi = new LikeHangshi();
                        likeHangshi.setHangshi(hangshi);
                        likeHangshi.setUser(user);
                        likeRepository.save(likeHangshi);
                    });

                }
        );
    }

    @Override
    @Transactional
    public void unLikeHangshi(LikeRequest likeRequest) {
        hangshiRepository.findById(likeRequest.getHangshiId()).ifPresent(
                hangshi -> {
                    userRepository.findById(likeRequest.getUserId()).ifPresent(user -> {
                        likeRepository.findByHangshiAndUser(hangshi, user).ifPresent(like -> {
                            likeRepository.delete(like);
                        });
                    });

                }
        );
    }


}
