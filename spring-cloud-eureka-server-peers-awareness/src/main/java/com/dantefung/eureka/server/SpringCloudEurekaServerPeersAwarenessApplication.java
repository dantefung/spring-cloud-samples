package com.dantefung.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaServerPeersAwarenessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerPeersAwarenessApplication.class, args);
    }

}
