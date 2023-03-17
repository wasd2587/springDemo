package com.zjs.product1.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjs.product1.service.ProduceRemote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 名字
 * @company 公司
 * @create 2023-03-15 21:08
 */

@RestController
public class ProductController {
    @Resource
    private ProduceRemote produceRemote;

    @GetMapping("/test/{name}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "failback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String test(@PathVariable("name")String name){
        return produceRemote.test(name);
    }

    @GetMapping("/methodOne/{name}")
    @ResponseBody
    public String methodOne(@PathVariable("name")String name){
        return produceRemote.methodOne(name);
    }

    public String failback(String name){
        return "P1 failback " + name;
    }
}
