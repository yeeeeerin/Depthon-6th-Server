package com.example.depthon3hangshi.domain;

import com.example.depthon3hangshi.dto.UserRequest;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class User {

    @GeneratedValue
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Hangshi> hangshiSet;


    private User(String name){
        this.name = name;
    }
    public static User of(UserRequest userRequest){

        return new User(userRequest.getName());

    }



}
