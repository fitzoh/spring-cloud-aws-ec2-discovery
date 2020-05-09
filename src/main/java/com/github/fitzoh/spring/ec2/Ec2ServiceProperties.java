package com.github.fitzoh.spring.ec2;

public class Ec2ServiceProperties {

	private String serviceId;

	private int port;

	private boolean secure;

	private Ec2HostType hostType;


	String getServiceId() {
		return serviceId;
	}

	void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	int getPort() {
		return port;
	}

	void setPort(int port) {
		this.port = port;
	}

	boolean isSecure() {
		return secure;
	}

	void setSecure(boolean secure) {
		this.secure = secure;
	}

	Ec2HostType getHostType() {
		return hostType;
	}

	void setHostType(Ec2HostType hostType) {
		this.hostType = hostType;
	}

}
