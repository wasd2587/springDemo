package com.zjs.product1.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/22 10:02
 */
@TableName(value = "user_b")
@Data
@Builder
public class UserDO {
    @TableId("id")
    private String id;
    @TableField("user_name")
    private String userName;
    @TableField("age")
    private int age;
    @TableField("address")
    private String address;
    @TableField("descp")
    private String descp;

    public UserDO() {
    }

    public UserDO(String id, String userName, int age, String address, String descp) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.address = address;
        this.descp = descp;
    }
}
