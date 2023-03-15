package com.zjs.product2.controller;



import com.zjs.product2.service.ProduceRemote;
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
    public String test(@PathVariable("name")String name){
        return produceRemote.test(name);
    }
}
