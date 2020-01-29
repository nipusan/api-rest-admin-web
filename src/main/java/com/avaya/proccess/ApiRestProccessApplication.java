package com.avaya.proccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiRestProccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestProccessApplication.class, args);
    }
}
