package com.example.feign.consumer;

import com.example.hello.service.api.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "eureka-client")
public interface RefactorHelloService extends HelloService {
}
