package com.github.fitzoh.spring.ec2;


public class Ec2ServiceProperties {

    private String id;

    private int port;

    private boolean secure;

    private String scheme;

    private Ec2HostType hostType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public Ec2HostType getHostType() {
        return hostType;
    }

    public void setHostType(Ec2HostType hostType) {
        this.hostType = hostType;
    }
}
