package com.dantefung.producer.hello;


import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @GetMapping
    public String handleRequest(@RequestParam(required = false) String name) {
        return "Node 1:" + StringUtils.defaultIfBlank(name,"") + "Say hi~~";
    }
}
