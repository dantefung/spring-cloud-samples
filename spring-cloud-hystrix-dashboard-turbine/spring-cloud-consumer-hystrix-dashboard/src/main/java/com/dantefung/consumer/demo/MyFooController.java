package com.dantefung.consumer.demo;

import com.dantefung.consumer.feign.HelloClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myfoo")
@Import(FeignClientsConfiguration.class)//In the above example FeignClientsConfiguration.class is the default configuration provided by Spring Cloud Netflix.
public class MyFooController {

    private HelloClient helloClient;

    //The Feign Contract object defines what annotations and values are valid on interfaces.
    // The autowired Contract bean provides supports for SpringMVC annotations,
    // instead of the default Feign native annotations.
    // IDEA环境下请无视MyFooController内参数的检查校验爆红
    public MyFooController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        helloClient = Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("", ""))
                .target(HelloClient.class, "http://PROVIDER/");
    }

    @GetMapping
    public String doRequest() {
        return helloClient.handleRequest();
    }

}
