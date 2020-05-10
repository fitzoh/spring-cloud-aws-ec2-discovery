package com.github.fitzoh.spring.ec2;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.*;

/**
 * Provides a more succinct conditional
 * <code>spring.cloud.consul.discovery.enabled</code>.
 *
 * @author Tim Ysewyn (https://github.com/spring-cloud/spring-cloud-consul/blob/fd083ca87478fcb2238722bd3d44b006152b2e91/spring-cloud-consul-discovery/src/main/java/org/springframework/cloud/consul/discovery/ConditionalOnConsulDiscoveryEnabled.java)
 * @author Andrew Fitzgerald
 * @since 2.2.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ConditionalOnProperty(value = "spring.cloud.aws.discovery.ec2.enabled",
        matchIfMissing = true)
public @interface ConditionalOnEc2DiscoveryEnabled {
}
