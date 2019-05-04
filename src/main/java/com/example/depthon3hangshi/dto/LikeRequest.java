package com.example.depthon3hangshi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LikeRequest {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("hangshi_id")
    private Long hangshiId;
}
