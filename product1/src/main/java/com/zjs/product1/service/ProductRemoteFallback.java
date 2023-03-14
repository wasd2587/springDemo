package com.zjs.product1.service;

import org.springframework.stereotype.Component;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/14 15:52
 */
@Component
public class ProductRemoteFallback implements ProduceRemote{

    @Override
    public String test(String name) {
        return "error";
    }
}
