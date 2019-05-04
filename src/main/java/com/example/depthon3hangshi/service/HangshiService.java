package com.example.depthon3hangshi.service;

import com.example.depthon3hangshi.dto.HangshiRequest;
import com.example.depthon3hangshi.dto.HangshiResponce;

public interface HangshiService {
    HangshiResponce createQuestion();
    void saveHangshi(HangshiRequest hangshiRequest);
}
