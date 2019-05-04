package com.example.depthon3hangshi.exception;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException() {
    }

    public NotFoundUserException(String msg) {
        super(msg);
    }
}
