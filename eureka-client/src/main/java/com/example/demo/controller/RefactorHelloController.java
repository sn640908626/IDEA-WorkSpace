package com.example.demo.controller;

import com.example.hello.service.api.HelloService;
import com.example.hello.service.api.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloService {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "hello" + user.getName() + "," + user.getAge();
    }
}
