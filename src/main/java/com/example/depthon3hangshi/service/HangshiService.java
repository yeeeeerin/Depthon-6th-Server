package com.example.depthon3hangshi.service;

import com.example.depthon3hangshi.dto.HangshiDto;
import com.example.depthon3hangshi.dto.HangshiRequest;
import com.example.depthon3hangshi.dto.HangshiResponse;
import com.example.depthon3hangshi.dto.LikeRequest;

import java.util.List;

public interface HangshiService {
    HangshiResponse createQuestion();

    void saveHangshi(HangshiRequest hangshiRequest);

    List<HangshiDto> getHangshiByLike(Long userId, int page);

    List<HangshiDto> getHangshiByDate(Long userId, int page);

    void likeHangshi(LikeRequest likeRequest);

    void unLikeHangshi(LikeRequest likeRequest);


}
