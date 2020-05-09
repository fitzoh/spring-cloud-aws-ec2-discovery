package com.github.fitzoh.spring.ec2;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Tag;

import org.springframework.cloud.client.ServiceInstance;

public class Ec2ServiceInstance implements ServiceInstance {

	private final Ec2ServiceProperties ec2ServiceProperties;
	private final Instance instance;

	Ec2ServiceInstance(Ec2ServiceProperties ec2ServiceProperties, Instance instance) {
		this.ec2ServiceProperties = ec2ServiceProperties;
		this.instance = instance;
	}

	@Override
	public String getInstanceId() {
		return instance.getInstanceId();
	}

	@Override
	public String getServiceId() {
		return ec2ServiceProperties.getServiceId();
	}

	@Override
	public String getHost() {
		return ec2ServiceProperties.getHostType().hostExtractor.apply(instance);
	}

	@Override
	public int getPort() {
		return ec2ServiceProperties.getPort();
	}

	@Override
	public boolean isSecure() {
		return ec2ServiceProperties.isSecure();
	}

	@Override
	public URI getUri() {
		String scheme = isSecure() ? "https" : "http";
		return URI.create(String.format("%s://%s:%d", scheme, getHost(), getPort()));
	}

	@Override
	public Map<String, String> getMetadata() {
		return instance.getTags().stream().collect(Collectors.toMap(Tag::getKey, Tag::getValue));
	}

	@Override
	public String getScheme() {
		return ec2ServiceProperties.getScheme();
	}
}
