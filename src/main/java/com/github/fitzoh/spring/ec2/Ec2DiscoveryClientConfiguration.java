package com.github.fitzoh.spring.ec2;


import com.amazonaws.services.ec2.AmazonEC2;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.CommonsClientAutoConfiguration;
import org.springframework.cloud.client.ConditionalOnBlockingDiscoveryEnabled;
import org.springframework.cloud.client.ConditionalOnDiscoveryEnabled;
import org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


/**
 * @author Spencer Gibb (https://github.com/spring-cloud/spring-cloud-consul/blob/fd083ca87478fcb2238722bd3d44b006152b2e91/spring-cloud-consul-discovery/src/main/java/org/springframework/cloud/consul/discovery/ConsulDiscoveryClientConfiguration.java)
 * @author Olga Maciaszek-Sharma (https://github.com/spring-cloud/spring-cloud-consul/blob/fd083ca87478fcb2238722bd3d44b006152b2e91/spring-cloud-consul-discovery/src/main/java/org/springframework/cloud/consul/discovery/ConsulDiscoveryClientConfiguration.java)
 * @author Tim Ysewyn (https://github.com/spring-cloud/spring-cloud-consul/blob/fd083ca87478fcb2238722bd3d44b006152b2e91/spring-cloud-consul-discovery/src/main/java/org/springframework/cloud/consul/discovery/ConsulDiscoveryClientConfiguration.java)
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnDiscoveryEnabled
@ConditionalOnBlockingDiscoveryEnabled
@ConditionalOnEc2DiscoveryEnabled
@EnableConfigurationProperties
@AutoConfigureBefore({ SimpleDiscoveryClientAutoConfiguration.class,
        CommonsClientAutoConfiguration.class })
public class Ec2DiscoveryClientConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Ec2DiscoveryProperties ec2DiscoveryProperties() {
        return new Ec2DiscoveryProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public Ec2DiscoveryClient consulDiscoveryClient(AmazonEC2 ec2,
                                                    Ec2DiscoveryProperties discoveryProperties) {
        return new Ec2DiscoveryClient(ec2, discoveryProperties);
    }

}
