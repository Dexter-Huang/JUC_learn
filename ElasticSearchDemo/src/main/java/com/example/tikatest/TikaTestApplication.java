package com.example.tikatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class TikaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TikaTestApplication.class, args);
    }

}
