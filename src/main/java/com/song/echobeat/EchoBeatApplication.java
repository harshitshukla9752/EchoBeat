package com.song.echobeat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.song.echobeat")
public class EchoBeatApplication {
    public static void main(String[] args) {
        SpringApplication.run(EchoBeatApplication.class, args);
    }
}
