package com.example.depthon3hangshi.controller;

import com.example.depthon3hangshi.dto.HangshiRequest;
import com.example.depthon3hangshi.dto.HangshiResponce;
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
    public ResponseDto<HangshiResponce> crateHangshi(){
        return ResponseDto.of(HttpStatus.OK,"success",hangshiService.createQuestion());
    }

    @PostMapping("/save_hangshi")
    public void saveHangshi(@RequestBody HangshiRequest hangshiRequest){
        hangshiService.saveHangshi(hangshiRequest);
    }



}
