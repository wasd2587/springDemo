package com.zjs.product1.intializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/4/3 15:13
 */
public class MyIntialinzer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("my initializer");
    }
}
