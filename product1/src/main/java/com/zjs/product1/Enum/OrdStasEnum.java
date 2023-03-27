package com.zjs.product1.Enum;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/27 16:07
 */
public enum OrdStasEnum {
    UnPay(0),
    Paying(1),
    Success(2),
    Failure(3),
    Refund_Processing(4),
    Refund_Success(5),
    Refund_Failure(6),
    Closed(7),  // 已关闭
    Revoked(8);// 已撤销

    private Integer value;

    private static Map<Integer, OrdStasEnum> valueMap = new HashMap<>();

    /* 初始化代码表 */
    static {
        for (OrdStasEnum paymentStateEnum : OrdStasEnum.values()) {
            valueMap.put(paymentStateEnum.value, paymentStateEnum);
        }
    }


    OrdStasEnum(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Integer getInteger() {
        return value;
    }

    public static Integer getRandum(){
        return (int) (Math.random() * 9);
    }
}
