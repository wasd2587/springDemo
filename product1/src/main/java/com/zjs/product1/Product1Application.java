package com.zjs.product1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.zjs.product1.dao")
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class Product1Application {

    public static void main(String[] args) {
        SpringApplication.run(Product1Application.class, args);
    }

}
