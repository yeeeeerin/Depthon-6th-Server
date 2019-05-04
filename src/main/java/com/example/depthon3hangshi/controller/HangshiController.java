package com.example.depthon3hangshi.controller;

import com.example.depthon3hangshi.dto.HangshiRequest;
import com.example.depthon3hangshi.dto.HangshiResponse;
import com.example.depthon3hangshi.dto.LikeRequest;
import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.service.HangshiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HangshiController {

    private final HangshiService hangshiService;

    @GetMapping("/get_hangshi")
    public ResponseDto<HangshiResponse> crateHangshi() {
        return ResponseDto.of(HttpStatus.OK, "success", hangshiService.createQuestion());
    }

    @PostMapping("/save_hangshi")
    public ResponseDto saveHangshi(@RequestBody HangshiRequest hangshiRequest) {
        hangshiService.saveHangshi(hangshiRequest);
        return ResponseDto.of(HttpStatus.OK, "success");
    }

    @GetMapping("/like")
    public ResponseDto like(@RequestBody LikeRequest likeRequest) {
        hangshiService.likeHangshi(likeRequest);
        return ResponseDto.of(HttpStatus.OK, "success");
    }

    @GetMapping("/unlike")
    public ResponseDto unLike(@RequestBody LikeRequest likeRequest) {
        hangshiService.likeHangshi(likeRequest);
        return ResponseDto.of(HttpStatus.OK, "success");
    }


}
