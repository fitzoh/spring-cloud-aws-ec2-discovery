package com.github.fitzoh.spring.ec2;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@ConfigurationProperties("spring.cloud.aws.discovery.ec2")
public class Ec2DiscoveryProperties {

    private List<Ec2ServiceProperties> services;

    public List<Ec2ServiceProperties> getServices() {
        return services;
    }

    public void setServices(List<Ec2ServiceProperties> services) {
        this.services = services;
    }

    public List<String> getServiceIds() {
        return services.stream().map(Ec2ServiceProperties::getId).collect(Collectors.toList());
    }

    public Map<String, Ec2ServiceProperties> getServicesById() {
        return services.stream().collect(Collectors.toMap(Ec2ServiceProperties::getId, Function.identity()));
    }
}

