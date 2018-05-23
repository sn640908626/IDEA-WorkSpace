package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//@EnableCircuitBreaker//断路器
//@EnableDiscoveryClient//服务发现与消费
//@SpringBootApplication
@SpringCloudApplication//包含以上三个 spring cloud标准应用应包含服务发现以及断路器
public class DemoApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
