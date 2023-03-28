package com.zjs.product1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjs.product1.entity.OrderDO;
import com.zjs.product1.entity.UserDO;

import java.util.Collection;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/27 16:18
 */
public interface OrderSeervice extends IService<OrderDO> {
    String batchMockInsert(Integer num);
    OrderDO getOrderByName(String name,int pageNum,int pageSize);
    String unionUserAndOrder();
}
