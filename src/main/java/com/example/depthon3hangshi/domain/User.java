package com.example.depthon3hangshi.domain;

import com.example.depthon3hangshi.dto.UserRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private User(String name){
        this.name = name;
    }
    public static User of(UserRequest userRequest){

        return new User(userRequest.getName());

    }



}
