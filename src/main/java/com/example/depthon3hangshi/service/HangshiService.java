package com.example.depthon3hangshi.service;

import com.example.depthon3hangshi.dto.HangshiRequest;
import com.example.depthon3hangshi.dto.HangshiResponse;
import com.example.depthon3hangshi.dto.LikeRequest;

public interface HangshiService {
    HangshiResponse createQuestion();

    void saveHangshi(HangshiRequest hangshiRequest);

    void likeHangshi(LikeRequest likeRequest);

    void unLikeHangshi(LikeRequest likeRequest);
}
