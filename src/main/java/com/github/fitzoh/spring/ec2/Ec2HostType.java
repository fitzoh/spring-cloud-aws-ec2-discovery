package com.github.fitzoh.spring.ec2;

import java.util.function.Function;

import com.amazonaws.services.ec2.model.Instance;

/**
 * Determiness which property to use for {@link Ec2ServiceInstance#getHost()}.
 */
public enum Ec2HostType {
	PRIVATE_IP(Instance::getPrivateIpAddress),
	PRIVATE_DNS(Instance::getPrivateDnsName),
	PUBLIC_IP(Instance::getPublicIpAddress),
	PUBLIC_DNS(Instance::getPublicDnsName);

	Function<Instance, String> hostExtractor;

	Ec2HostType(Function<Instance, String> hostExtractor) {
		this.hostExtractor = hostExtractor;
	}
}
