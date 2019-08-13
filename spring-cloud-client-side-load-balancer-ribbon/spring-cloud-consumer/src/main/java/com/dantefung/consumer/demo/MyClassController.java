package com.dantefung.consumer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Using the Ribbon API Directly
 */
@RestController
@RequestMapping("/myClass")
public class MyClassController {

    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String handleRequest() {
        StringBuffer sb = new StringBuffer("返回的内容:");
        // Service ID一定要大写
        ServiceInstance instance = loadBalancer.choose("PRODUCER");
        System.out.println(String.format("%s:%s:%s", instance.getServiceId(), instance.getHost(), instance.getPort()));
        if (instance != null) {
            // URI producerUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
            // ... do something with the URI
            try {
                URL url = new URL(String.format("http://%s:%s/%s", instance.getHost(), instance.getPort(), "hello"));
                URLConnection connection = url.openConnection();
                try(InputStream in = connection.getInputStream()) {
                    BufferedReader bw =new BufferedReader( new InputStreamReader(new BufferedInputStream(in)));
                    String line = "";
                    while ((line = bw.readLine()) != null) {
                        sb.append(line);
                    }
                } catch (Exception ex) {

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @GetMapping("/greet")
    public String greet() {
        String url = "http://producer:8001/hello";
//        ServiceInstance instance = loadBalancer.choose("PRODUCER");
//        String url = String.format("http://%s:%s/%s", instance.getHost(), instance.getPort(), "hello");
        return restTemplate.getForObject(url, String.class);
    }


}
