package com.example.javaproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JavaProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaProductServiceApplication.class, args);
    }

}
