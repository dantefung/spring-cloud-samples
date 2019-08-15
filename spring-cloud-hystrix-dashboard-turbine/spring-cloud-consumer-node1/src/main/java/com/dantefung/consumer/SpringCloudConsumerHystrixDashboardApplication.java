package com.dantefung.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
// Hystrix相关注解
@EnableCircuitBreaker
@EnableHystrixDashboard
public class SpringCloudConsumerHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerHystrixDashboardApplication.class, args);
    }

}
