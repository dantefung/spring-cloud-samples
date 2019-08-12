package com.dantefung.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SpringCloudEurekaClientApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello World!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClientApplication.class, args);
    }

}
