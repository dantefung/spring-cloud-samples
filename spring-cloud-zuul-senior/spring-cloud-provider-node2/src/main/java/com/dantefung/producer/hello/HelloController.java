package com.dantefung.producer.hello;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private Logger logger =  LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String handleRequest(@RequestParam(required = false) String name) {
        return "Node 2:" + StringUtils.defaultIfBlank(name,"") + "Say hi~~";
    }


    @GetMapping("/hi")
    public String hi(@RequestParam(required = false) String name) {
        logger.info(" enter hi method :[name={}]",name);
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return "Node 1:" + StringUtils.defaultIfBlank(name,"") + "Say hi~~";
    }
}
