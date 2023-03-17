package com.zjs.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 名字
 * @company 公司
 * @create 2023-03-15 21:33
 */

@FeignClient(value = "EUREKA-CLIENT-PRODUCER")
//@FeignClient(value = "EUREKA-CLIENT-PRODUCER",fallback = ConsumerFallback.class)
public interface ConsumerService {
    @GetMapping("/test/{name}")
    String test(@PathVariable("name") String name);

    @GetMapping("/methodOne/{name}")
    String methodOne(@PathVariable("name") String name);
}
