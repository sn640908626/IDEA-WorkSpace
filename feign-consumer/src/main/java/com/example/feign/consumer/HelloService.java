package com.example.feign.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")
public interface HelloService {
    @RequestMapping("/helloWorld")
    String helloWorld();

    @RequestMapping(value = "/hello1")
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3")
    String hello(@RequestBody User user);
}
