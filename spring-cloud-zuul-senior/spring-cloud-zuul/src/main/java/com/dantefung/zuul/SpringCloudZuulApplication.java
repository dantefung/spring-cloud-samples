package com.dantefung.zuul;

import com.dantefung.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy // 支持网关路由
@SpringBootApplication
public class SpringCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulApplication.class, args);
    }


    /**
     * 将TokenFilter加入到请求拦截队列
     * @return
     */
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

}
