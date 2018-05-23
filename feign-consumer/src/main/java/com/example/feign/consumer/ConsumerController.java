package com.example.feign.consumer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    HelloService helloService;

    @Resource
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer")
    public String helloConsumer(){
        return helloService.helloWorld();
    }

    @RequestMapping(value = "/feign-consumer2")
    public String helloConsumer2(){
        return helloService.hello("赵丽颖") + "\n" +
                helloService.hello("郑爽", 27) + "\n" +
                helloService.hello(new User("李一桐", 26));
    }

    @RequestMapping(value = "/feign-consumer3")
    public String helloConsumer3(){
        return refactorHelloService.hello("zly") + "\n\r" +
                refactorHelloService.hello("zs", 27) + "\n" +
                refactorHelloService.hello(new com.example.hello.service.api.User("ylz",27));
    }
}
