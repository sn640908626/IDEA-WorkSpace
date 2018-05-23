package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        // return restTemplate.getForEntity("http://eureka-client/hello",String.class).getBody();
        return restTemplate.getForObject("http://eureka-client/hello", String.class);
    }

    public String helloFallback(){
        return "error";
    }
}
