package com.zjs.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjs.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 名字
 * @company 公司
 * @create 2023-03-15 21:32
 */

@RestController
@Slf4j
public class ConsumerController {
    @Resource
    private ConsumerService consumerService;

    @GetMapping("/consumer/test/{name}")
    @HystrixCommand(fallbackMethod = "testFallBack"
            ,commandProperties = {
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),// 统计窗口时间，默认10s
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 断路器熔断的最小请求数，默认20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),// 断路器打开后，多久以后开始尝试恢复，默认5s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),// 请求失败率，默认50%
            @HystrixProperty(name = "threadpool.default.coreSize",value = "10"),
            @HystrixProperty(name = "threadpool.default.maxQueueSize",value = "10"),
            @HystrixProperty(name = "threadpool.default.queueSizeRejectionThreshold",value = "15")
    }

    )
    public String test(@PathVariable("name")String name){
        log.info("star method test");
        return consumerService.test(name);
    }

    @GetMapping("/consumer/methodOne/{name}")
    public String methodOne(@PathVariable("name")String name){
        log.info("star method test");
        return consumerService.methodOne(name);
    }

    public String testFallBack(String string){
        log.info("star fallback");
        return "consumer fallback" + string;
    }

}
