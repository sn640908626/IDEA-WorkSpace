package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    private HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer")
    public String helloConsumer(){
        return helloService.helloService();
    }
}
