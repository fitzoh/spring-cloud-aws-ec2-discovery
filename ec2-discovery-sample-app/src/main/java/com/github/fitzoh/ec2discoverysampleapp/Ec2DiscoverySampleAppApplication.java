package com.github.fitzoh.ec2discoverysampleapp;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.github.fitzoh.spring.ec2.Ec2DiscoveryClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@Import(Ec2DiscoveryClientConfiguration.class)
@RestController
@SpringBootApplication
public class Ec2DiscoverySampleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ec2DiscoverySampleAppApplication.class, args);
    }

    @Bean
    public AmazonEC2 ec2() {
        return AmazonEC2ClientBuilder.defaultClient();
    }

}
