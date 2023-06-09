package com.zjs.product2.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 名字
 * @company 公司
 * @create 2023-03-15 21:10
 */

@Service
@Slf4j
public class ProductService implements ProduceRemote {
    @Override
    @SneakyThrows
    public String test(String name){
        if (System.currentTimeMillis() % 3 == 0){
            throw  new Exception("123");
        }
        String result = "\"HI \" + name + \",I'm P2\"";
        log.info(result);
        return result;
    }
}
