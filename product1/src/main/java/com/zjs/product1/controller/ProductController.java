package com.zjs.product1.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjs.product1.entity.UserDO;
import com.zjs.product1.service.ProduceRemote;
import com.zjs.product1.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 名字
 * @company 公司
 * @create 2023-03-15 21:08
 */

@RestController
public class ProductController implements ProduceRemote{
    @Resource
    private ProduceRemote produceRemote;
    @Resource
    private ProductService productService;

    @GetMapping("/test/{name}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "failback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String test(@PathVariable("name")String name){
        return productService.test(name);
    }

    @GetMapping("/methodOne/{name}")
    @ResponseBody
    public String methodOne(@PathVariable("name")String name){
        return productService.methodOne(name);
    }

    @GetMapping("/selectUser/{name}")
    @ResponseBody
    public List<UserDO> selectUser(@PathVariable("name")String name){
        return productService.selectUser(name);
    }

    @GetMapping("/selectUserById/{id}")
    @ResponseBody
    public List<UserDO> selectUserbById(@PathVariable("id")String id){
        return productService.selectUserById(id);
    }

    @GetMapping("/batchInsert/{num}")
    @ResponseBody
    public String batchInsert(@PathVariable("num")long num){
        return productService.batchInsert(num);
    }

    @GetMapping("/batchInsert1/{num}")
    @ResponseBody
    public String batchInsert1(@PathVariable("num")long num){
        return productService.batchInsert1(num);
    }

    @PostMapping("/msg/push")
    @ResponseBody
    public String msgPush(@RequestBody String json){
        return productService.msgPush(json);
    }

    public String failback(String name){
        return "P1 failback " + name;
    }
}
