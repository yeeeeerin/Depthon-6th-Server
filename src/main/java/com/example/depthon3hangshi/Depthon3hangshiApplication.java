package com.example.depthon3hangshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Depthon3hangshiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Depthon3hangshiApplication.class, args);
    }

}
