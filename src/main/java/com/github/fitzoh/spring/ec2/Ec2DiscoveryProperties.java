package com.github.fitzoh.spring.ec2;

import java.util.HashMap;
import java.util.Map;

public class Ec2DiscoveryProperties {

	private Map<String, Ec2ServiceProperties> services = new HashMap<>();

	public Map<String, Ec2ServiceProperties> getServices() {
		return services;
	}

	public void setServices(Map<String, Ec2ServiceProperties> services) {
		this.services = services;
	}
}
