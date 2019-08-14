package com.dantefung.consumer.service;

import com.dantefung.consumer.feign.HelloClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 摘自: https://cloud.spring.io/spring-cloud-static/Greenwich.SR2/single/spring-cloud.html#_circuit_breaker_hystrix_clients
 * The @HystrixCommand is provided by a Netflix contrib library called “javanica”.
 * Spring Cloud automatically wraps Spring beans with that annotation in a proxy that is connected to the Hystrix circuit breaker.
 * The circuit breaker calculates when to open and close the circuit and what to do in case of a failure.
 *
 * To configure the @HystrixCommand you can use the commandProperties attribute with a list of @HystrixProperty annotations.
 * See here for more details. See the Hystrix wiki for details on the properties available.
 */
@Component
public class StoreIntegration {

    @Autowired
    private HelloClient helloClient;

//    @HystrixCommand(fallbackMethod = "defaultStores")
//    public Object getStores(Map<String, Object> parameters) {
//        //do stuff that might fail
//        // 模拟业务执行失败
//        return 1/0;
//    }


    /**
     * 由于openfeign中依赖有
     * io.github.openfeign:feign-hystrix:10.2.3
     *   - com.netflix.hystrix:hystrix-core:1.5.18
     *
     * 所以可以通过@FeignClient(name="DEMO", fallback=DemoFallback.class)方式来
     * 定义服务降低策略(也就是兜底的返回)
     *
     * 在application.yml中将feign hystrix support 关闭
     * feign:
     *   hystrix:
     *     enabled: false
     *
     * 本例是为了测试  @HystrixCommand(fallbackMethod = "defaultStores")的使用方式
     *
     * 注意事项:
     * 1. 熔断的时间片(rolling window 滑动窗口)要比ribbon clients的timeout(超时等待时间)要长
     * 原文档描述: When using Hystrix commands that wrap Ribbon clients you want to make sure your Hystrix timeout is configured to be longer than the configured Ribbon timeout,
     * including any potential retries that might be made.
     *
     * @param parameters
     * @return
     */
    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail
        // 模拟服务调用失败
        return helloClient.handleRequest();
    }

    /**
     * 备胎方法
     * @param parameters
     * @return
     */
    public Object defaultStores(Map<String, Object> parameters) {
        return "业务降级: 我是默认返回."/* something useful */;
    }
}