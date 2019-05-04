package com.example.depthon3hangshi.service.Impl;

import com.example.depthon3hangshi.domain.Hangshi;
import com.example.depthon3hangshi.domain.WordCollector;
import com.example.depthon3hangshi.dto.HangshiRequest;
import com.example.depthon3hangshi.dto.HangshiResponce;
import com.example.depthon3hangshi.repository.HangshiRepository;
import com.example.depthon3hangshi.repository.UserRepository;
import com.example.depthon3hangshi.service.HangshiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HangshiServiceImpl implements HangshiService {

    private final HangshiRepository hangshiRepository;
    private final UserRepository userRepository;

    @Override
    public HangshiResponce createQuestion(){
        HangshiResponce hangshiResponece = new HangshiResponce();
        hangshiResponece.setHangshi(WordCollector.getRandom());
        return hangshiResponece;
    }

    @Override
    public void saveHangshi(HangshiRequest hangshiRequest) {

        userRepository.findByName(hangshiRequest.getUsername())
                .ifPresent(user -> {
                    Hangshi hangshi = Hangshi.of(hangshiRequest,user);
                    hangshiRepository.save(hangshi);
                });

    }

}
