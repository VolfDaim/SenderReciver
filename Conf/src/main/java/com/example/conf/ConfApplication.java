package com.example.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableConfigServer
public class ConfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfApplication.class, args);
    }

}
