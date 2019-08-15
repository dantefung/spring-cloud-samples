package com.dantefung.config.client.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * 读取配置中心的配置并注入env变量
     */
    @Value("${env}")
    private String env;

    @RequestMapping("/hello")
    public String from() {
        return "当前环境为:" + this.env;
    }
}
