package com.dantefung.consumer.feign;

import org.springframework.stereotype.Component;

/**
 *  防止雪崩效应
 *  服务降级处理策略
 *
 */
@Component// You also need to declare your implementation as a Spring bean.
public class HelloClientFallback implements HelloClient {

    /**
     * Fallback相当于是降级操作. 对于查询操作, 我们可以实现一个fallback方法,
     * 当请求后端服务出现异常的时候, 可以使用fallback方法返回的值.
     * fallback方法的返回值一般是设置的默认值或者来自缓存.
     *
     *
     *
     * @return
     */
    @Override
    public String handleRequest() {
        return "Hystrix alert: Sorry, your request was rejected!";
    }
}
