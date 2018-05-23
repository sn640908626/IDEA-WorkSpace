package com.example.hello.service.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello4")
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6")
    String hello(@RequestBody User user);
}
