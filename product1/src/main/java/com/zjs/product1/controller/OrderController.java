package com.zjs.product1.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjs.product1.service.OrderSeervice;
import com.zjs.product1.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/27 17:03
 */
@RestController
public class OrderController {
    @Resource
    private OrderSeervice orderSeervice;

    @GetMapping("/order/batchInsert/{num}")
    @ResponseBody
    public String batchInsert(@PathVariable("num")Integer num){
        return orderSeervice.batchMockInsert(num);
    }
}
