package com.example.depthon3hangshi.service.Impl;

import com.example.depthon3hangshi.domain.Hangshi;
import com.example.depthon3hangshi.domain.LikeHangshi;
import com.example.depthon3hangshi.domain.User;
import com.example.depthon3hangshi.domain.WordCollector;
import com.example.depthon3hangshi.dto.HangshiDto;
import com.example.depthon3hangshi.dto.HangshiRequest;
import com.example.depthon3hangshi.dto.HangshiResponse;
import com.example.depthon3hangshi.dto.LikeRequest;
import com.example.depthon3hangshi.exception.ExistLikeException;
import com.example.depthon3hangshi.exception.NotFoundUserException;
import com.example.depthon3hangshi.repository.HangshiRepository;
import com.example.depthon3hangshi.repository.LikeHangshiRepository;
import com.example.depthon3hangshi.repository.UserRepository;
import com.example.depthon3hangshi.service.HangshiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
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
    @Transactional(readOnly = true)
    public List<HangshiDto> getHangshiByLike(Long userId, int page) {
        Pageable pageable = PageRequest.of(page, 20);
        User user = userRepository.findById(userId).orElseThrow(NotFoundUserException::new);
        return hangshiRepository.findAllByOrderByLikeCountDesc(pageable).stream()
                .map(hangshi -> {
                    boolean like = false;
                    //내가 좋아요 했다면
                    if (likeRepository.findByHangshiAndUser(hangshi, user).isPresent()) {
                        like = true;
                    }
                    log.info("hangshi - " + hangshi.getId());
                    return HangshiDto.of(hangshi, like);
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<HangshiDto> getHangshiByDate(Long userId, int page) {
        Pageable pageable = PageRequest.of(page, 20);
        User user = userRepository.findById(userId).orElseThrow(NotFoundUserException::new);
        return hangshiRepository.findAllByOrderByCreatedAtDesc(pageable).stream()
                .map(hangshi -> {
                    boolean like = false;
                    //내가 좋아요 했다면
                    if (likeRepository.findByHangshiAndUser(hangshi, user).isPresent()) {
                        like = true;
                    }
                    log.info("hangshi - " + hangshi.getId());
                    return HangshiDto.of(hangshi, like);
                })
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void likeHangshi(LikeRequest likeRequest) {

        hangshiRepository.findById(likeRequest.getHangshiId()).ifPresent(
                hangshi -> {
                    userRepository.findById(likeRequest.getUserId()).ifPresent(user -> {
                        //이미 라이크 했다면
                        likeRepository.findByHangshiAndUser(hangshi, user).ifPresent(ExistLikeException::new);

                        LikeHangshi likeHangshi = new LikeHangshi();
                        likeHangshi.setHangshi(hangshi);
                        likeHangshi.setUser(user);
                        likeRepository.save(likeHangshi);
                        hangshi.setLikeCount(hangshi.getLikeCount() + 1);
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
                            hangshi.setLikeCount(hangshi.getLikeCount() - 1);
                        });
                    });

                }
        );
    }


}
