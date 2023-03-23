package com.zjs.product1;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/23 10:04
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据库配置
 * @author beibei
 *
 */
@Component // 必须要有这个注解,否则无法在其他地方自动注入
@ConfigurationProperties(prefix="spring.datasource")//此处表示只读取application.yml中spring下面的datasource下面的属性
@Data
public class DBProperties {

    //各个属性名称和application.yml中spring.datasource下面的各个属性key一一对应
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String initialSize;
    private String minIdle;
    private String maxActive;
    private String maxWait;
    private String showsql;
//为了节省篇幅，此处略去getter、setter方法
}
