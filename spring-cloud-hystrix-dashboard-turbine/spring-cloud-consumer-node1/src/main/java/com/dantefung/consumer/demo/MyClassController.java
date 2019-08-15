package com.dantefung.consumer.demo;

import com.dantefung.consumer.feign.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Using the Ribbon API Directly
 * Reference:https://cloud.spring.io/spring-cloud-static/Greenwich.SR2/single/spring-cloud.html#spring-cloud-feign
 */
@RestController
@RequestMapping
public class MyClassController {

    /**
     *  Declarative REST Client: Feign
     */
    @Autowired
    private HelloClient helloClient;

    @GetMapping
    public String index() {
        return "返回:"+helloClient.handleRequest();
    }

}
