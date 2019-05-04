package com.example.depthon3hangshi.exception;

import com.example.depthon3hangshi.domain.LikeHangshi;

public class ExistLikeException extends RuntimeException {
    public ExistLikeException() {
    }

    public ExistLikeException(String msg) {
        super(msg);
    }

    public ExistLikeException(LikeHangshi likeHangshi) {

    }
}
