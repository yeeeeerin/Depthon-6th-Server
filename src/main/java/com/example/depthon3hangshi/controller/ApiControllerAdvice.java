package com.example.depthon3hangshi.controller;

import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.exception.ExistUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler(ExistUserException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseDto handleBadRequestException() {
        return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, "Exist User!!");
    }
}
