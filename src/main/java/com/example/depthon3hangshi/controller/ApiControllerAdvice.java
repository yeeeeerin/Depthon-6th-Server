package com.example.depthon3hangshi.controller;

import com.example.depthon3hangshi.dto.ResponseDto;
import com.example.depthon3hangshi.exception.CanNotUnlikeException;
import com.example.depthon3hangshi.exception.ExistLikeException;
import com.example.depthon3hangshi.exception.ExistUserException;
import com.example.depthon3hangshi.exception.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler(ExistUserException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseDto handleExistUserException() {
        return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, "Exist User!!");
    }

    @ExceptionHandler(NotFoundUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseDto handleNonExistUserException() {
        return ResponseDto.of(HttpStatus.NOT_FOUND, "Not Found User!!");
    }

    @ExceptionHandler(ExistLikeException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseDto handleExistLikeException() {
        return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, "Exist Like!!");
    }

    @ExceptionHandler(CanNotUnlikeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto handleCanNotUnlikeException() {
        return ResponseDto.of(HttpStatus.BAD_REQUEST, "Can Not Unlike!!");
    }
}
