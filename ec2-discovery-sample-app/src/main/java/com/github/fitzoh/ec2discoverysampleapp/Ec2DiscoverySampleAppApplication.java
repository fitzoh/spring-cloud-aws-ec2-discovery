package com.github.fitzoh.ec2discoverysampleapp;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.github.fitzoh.spring.ec2.Ec2DiscoveryClient;
import com.github.fitzoh.spring.ec2.Ec2DiscoveryProperties;
import com.github.fitzoh.spring.ec2.Ec2HostType;
import com.github.fitzoh.spring.ec2.Ec2ServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

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

    @Bean
    public Ec2DiscoveryProperties properties() {
        Ec2DiscoveryProperties ec2DiscoveryProperties = new Ec2DiscoveryProperties();
        Ec2ServiceProperties service = new Ec2ServiceProperties();
        service.setHostType(Ec2HostType.PRIVATE_IP);
        service.setSecure(true);
        service.setPort(443);
        service.setScheme("https");
        service.setServiceId("myService");
        ec2DiscoveryProperties.getServices().put("myService", service);

        return ec2DiscoveryProperties;
    }

    @Bean
    public DiscoveryClient discoveryClient(AmazonEC2 ec2, Ec2DiscoveryProperties properties) {
        return new Ec2DiscoveryClient(ec2, properties);
    }


}
