package com.dantefung.consumer.demo;

import com.dantefung.consumer.service.StoreIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping
public class HystrixTestController {

    @Autowired
    private StoreIntegration storeIntegration;

    @GetMapping("/hystrix/test")
    public Object test() {
        return storeIntegration.getStores(new HashMap<>());
    }
}
