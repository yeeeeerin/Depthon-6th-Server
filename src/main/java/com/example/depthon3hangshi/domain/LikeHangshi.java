package com.example.depthon3hangshi.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class LikeHangshi {

    @GeneratedValue
    @Id
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hangshi_id")
    private Hangshi hangshi;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
