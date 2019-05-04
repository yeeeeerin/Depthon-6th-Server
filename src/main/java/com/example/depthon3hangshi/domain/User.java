package com.example.depthon3hangshi.domain;

import com.example.depthon3hangshi.dto.UserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @GeneratedValue
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
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
