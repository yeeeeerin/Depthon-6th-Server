package com.example.depthon3hangshi.dto;

import lombok.Value;

@Value
public class UserLoginResponse {
    private Long id;
    private String name;

    public static UserLoginResponse of(Long id, String name) {
        return new UserLoginResponse(id, name);
    }
}
