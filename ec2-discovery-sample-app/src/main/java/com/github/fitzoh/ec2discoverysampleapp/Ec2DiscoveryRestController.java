package com.github.fitzoh.ec2discoverysampleapp;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Ec2DiscoveryRestController {
    private final DiscoveryClient discoveryClient;

    public Ec2DiscoveryRestController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/services")
    public List<String> services() {
        return discoveryClient.getServices();
    }

    @GetMapping("/services/{service}")
    public List<ServiceInstance> serviceInstances(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }
}
