package com.zjs.product1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/14 15:49
 */
@Service
public interface ProduceRemote {
    String test(@RequestParam(value = "name")String name);

    public String methodOne(@PathVariable("name")String name);
}
