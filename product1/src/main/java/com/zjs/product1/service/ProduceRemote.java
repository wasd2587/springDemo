package com.zjs.product1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/14 15:49
 */
@FeignClient(name = "eureka-client-producer")
@Service
public interface ProduceRemote {

    @GetMapping("/test")
    String test(@RequestParam(value = "name")String name);
}
