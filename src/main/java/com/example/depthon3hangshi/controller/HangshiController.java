package com.example.depthon3hangshi.controller;

import com.example.depthon3hangshi.dto.*;
import com.example.depthon3hangshi.service.HangshiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hangshis")
public class HangshiController {

    private final HangshiService hangshiService;

    @GetMapping("/create")
    public ResponseDto<HangshiResponse> crateHangshi() {
        return ResponseDto.of(HttpStatus.OK, "success", hangshiService.createQuestion());
    }

    @GetMapping("/get_by_like")
    public List<HangshiDto> getHangshisByLike(@RequestParam Long userId,
                                              @RequestParam int page) {
        return hangshiService.getHangshiByLike(userId, page);
    }

    @GetMapping("/get_by_date")
    public List<HangshiDto> getHangshisByDate(@RequestParam Long userId,
                                              @RequestParam int page) {
        return hangshiService.getHangshiByDate(userId, page);
    }

    @PostMapping("/save_hangshi")
    public ResponseDto saveHangshi(@RequestBody HangshiRequest hangshiRequest) {
        hangshiService.saveHangshi(hangshiRequest);
        return ResponseDto.of(HttpStatus.OK, "success");
    }

    @PostMapping("/like")
    public ResponseDto like(@RequestBody LikeRequest likeRequest) {
        hangshiService.likeHangshi(likeRequest);
        return ResponseDto.of(HttpStatus.OK, "success");
    }

    @PostMapping("/unlike")
    public ResponseDto unLike(@RequestBody LikeRequest likeRequest) {
        hangshiService.unLikeHangshi(likeRequest);
        return ResponseDto.of(HttpStatus.OK, "success");
    }


}
