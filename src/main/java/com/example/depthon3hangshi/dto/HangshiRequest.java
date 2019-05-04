package com.example.depthon3hangshi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HangshiRequest {

    @JsonProperty("word_first")
    private String wordFirst;

    @JsonProperty("word_second")
    private String wordSecond;

    @JsonProperty("word_third")
    private String wordThird;

    @JsonProperty("username")
    private String username;
}
