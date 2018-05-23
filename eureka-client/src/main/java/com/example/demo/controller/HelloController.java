package com.example.demo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

@RestController
public class HelloController {

    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "/hello")
    public String hello() throws InterruptedException {
        long start = System.currentTimeMillis();
        ServiceInstance instance = client.getLocalServiceInstance();
        //让处理线程等待几秒钟
        Thread.sleep(new Random().nextInt(3000));
        String result = "/hello,host:" + instance.getHost() +
                ",service_id:" + instance.getServiceId() +
                ",port:" + instance.getPort() +
                ",metadata:" + instance.getMetadata() +
                ",uri:" + instance.getUri();
        long end = System.currentTimeMillis();
        System.out.println(",spend time:" + (end - start));
        return result + ",spend time:" + (end - start);
    }

    @RequestMapping(value = "/helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }

    @RequestMapping(value = "/hello1")
    public String hello(@RequestParam String name) {
        return "hello" + name;
    }

    @RequestMapping(value = "/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3")
    public String hello(@RequestBody User user) {
        return "hello" + user.getName() + "," + user.getAge();
    }
}
