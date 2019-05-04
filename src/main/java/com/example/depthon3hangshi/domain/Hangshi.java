package com.example.depthon3hangshi.domain;

import com.example.depthon3hangshi.dto.HangshiRequest;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Hangshi {

    @Id
    @GeneratedValue
    @Column(name = "hangshi_id")
    private Long id;

    private String wordFirst;
    private String wordSecond;
    private String wordThird;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "hangshi",cascade = CascadeType.ALL)
    private Set<LikeHangshi> likes;

    private Hangshi(String wordFirst,String wordSecond,String wordThird,User user){
        this.wordFirst = wordFirst;
        this.wordSecond = wordSecond;
        this.wordThird = wordThird;
        this.user = user;
    }


    public static Hangshi of(HangshiRequest hangshiRequest,User user){
        return new Hangshi(hangshiRequest.getWordFirst(),hangshiRequest.getWordSecond(),hangshiRequest.getWordThird(),user);
    }

}
