package com.github.fitzoh.spring.ec2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * Amazon EC2 based {@link DiscoveryClient}
 */
public class Ec2DiscoveryClient implements DiscoveryClient {

	private final AmazonEC2 ec2;
	private final Ec2DiscoveryProperties ec2DiscoveryProperties;

	public Ec2DiscoveryClient(AmazonEC2 ec2, Ec2DiscoveryProperties ec2DiscoveryProperties) {
		this.ec2 = ec2;
		this.ec2DiscoveryProperties = ec2DiscoveryProperties;
	}

	@Override
	public String description() {
		return "Amazon EC2 Discovery Client";
	}

	@Override
	public List<ServiceInstance> getInstances(String serviceId) {
		Ec2ServiceProperties serviceProperties = ec2DiscoveryProperties.getServices().get(serviceId);
		DescribeInstancesRequest describeInstancesRequest = new DescribeInstancesRequest();

		return ec2.describeInstances(describeInstancesRequest)
				.getReservations()
				.stream()
				.flatMap(reservation -> reservation.getInstances().stream())
				.map(instance -> new Ec2ServiceInstance(serviceProperties, instance))
				.collect(Collectors.toList());
	}

	@Override
	public List<String> getServices() {
		return new ArrayList<>(ec2DiscoveryProperties.getServices().keySet());
	}
}
