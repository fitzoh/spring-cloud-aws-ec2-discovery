package com.github.fitzoh.ec2discoverysampleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ec2DiscoverySampleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ec2DiscoverySampleAppApplication.class, args);
    }

    @GetMapping
    public String hello(){
        return "hello world";
    }

}
