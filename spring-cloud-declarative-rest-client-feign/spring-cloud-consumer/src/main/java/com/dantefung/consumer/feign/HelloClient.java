package com.dantefung.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "PROVIDER")
public interface HelloClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello/")
    String handleRequest();

}
