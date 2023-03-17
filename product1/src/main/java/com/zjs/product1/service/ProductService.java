package com.zjs.product1.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;

/**
 * @author 名字
 * @company 公司
 * @create 2023-03-15 21:10
 */

@Service
@Slf4j
public class ProductService implements ProduceRemote {
    @Override
    public String test(String name){
        String result = null;
        try {
            Thread.sleep(2000);
            result = "\"HI \" + name + \",I'm P1\"";
            log.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String methodOne(String name) {
        String result = null;
        try {
            //Thread.sleep(2000);
            result = "method + " + name;
            log.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
