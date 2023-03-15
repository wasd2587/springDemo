package com.zjs.product2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/14 15:49
 */
@Service
public interface ProduceRemote {
    String test(@RequestParam(value = "name") String name);
}
