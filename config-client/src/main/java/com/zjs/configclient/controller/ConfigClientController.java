package com.zjs.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/14 16:38
 */
@Controller
@RefreshScope
public class ConfigClientController {
    @Value("${app.env}")
    private String str;

    @GetMapping("/name")
    public String test() {
        return this.str;
    }
}
