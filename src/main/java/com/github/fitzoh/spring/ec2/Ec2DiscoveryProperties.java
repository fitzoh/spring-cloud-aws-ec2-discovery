package com.github.fitzoh.spring.ec2;

import java.util.Map;

public class Ec2DiscoveryProperties {

	private Map<String, Ec2ServiceProperties> services;

	Map<String, Ec2ServiceProperties> getServices() {
		return services;
	}

	void setServices(Map<String, Ec2ServiceProperties> services) {
		this.services = services;
	}
}
