package com.zjs.consumer.service;

import org.springframework.stereotype.Component;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/14 15:52
 */
@Component
public class ConsumerFallback implements ConsumerService{

    @Override
    public String test(String name) {
        return "error";
    }

    @Override
    public String methodOne(String name) {
        return "method ONE error";
    }
}
