package com.example.depthon3hangshi.dto;


import com.example.depthon3hangshi.domain.Hangshi;
import lombok.Getter;
import lombok.Setter;

/*
 * 좋아요 판별 기능 가능
 * */
@Getter
@Setter
public class HangshiDto {
    private Long id;

    private String wordFirst;
    private String wordSecond;
    private String wordThird;

    private Integer likeCount;

    private String username;

    private boolean like;

    private HangshiDto(Long id,
                       String wordFirst,
                       String wordSecond,
                       String wordThird,
                       Integer likeCount,
                       String username,
                       boolean like) {

        this.id = id;
        this.wordFirst = wordFirst;
        this.wordSecond = wordSecond;
        this.wordThird = wordThird;
        this.likeCount = likeCount;
        this.username = username;
        this.like = like;
    }

    public static HangshiDto of(Hangshi hangshi, boolean like) {
        return new HangshiDto(hangshi.getId(),
                hangshi.getWordFirst(),
                hangshi.getWordSecond(),
                hangshi.getWordThird(),
                hangshi.getLikeCount(),
                hangshi.getUser().getName(),
                like);
    }

    public void setLike(boolean like) {

        this.like = like;

    }

}
