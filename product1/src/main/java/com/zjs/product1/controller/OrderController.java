package com.zjs.product1.controller;

import com.zjs.product1.service.OrderSeervice;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping
    public String unionUserAndOrder(){
        return orderSeervice.unionUserAndOrder();
    }
}
