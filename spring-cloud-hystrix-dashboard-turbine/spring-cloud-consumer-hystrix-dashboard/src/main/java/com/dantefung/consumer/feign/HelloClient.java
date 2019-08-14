package com.dantefung.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * hystrix circuit Breaker
 * 参见资料:https://github.com/Netflix/Hystrix/wiki/How-it-Works#CircuitBreaker
 *
 * Feign Hystrix Fallbacks
 * 参见文档:https://cloud.spring.io/spring-cloud-static/Greenwich.SR2/single/spring-cloud.html#spring-cloud-feign
 *
 * Hystrix supports the notion of a fallback:
 * 熔断器支持降级的概念：
 *  a default code path that is executed when they circuit is open or there is an error.
 *
 *  To enable fallbacks for a given @FeignClient set the fallback attribute to the class name that implements the fallback.
 *  通过给定@FeignClient注解，并设置fallback属性为实现了降级策略的类型名
 *
 */
@FeignClient(value = "PROVIDER", fallback = HelloClientFallback.class)
public interface HelloClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello/")
    String handleRequest();

}



