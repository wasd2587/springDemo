package com.zjs.product1.dao;

import com.zjs.product1.entity.OrderDO;
import com.zjs.product1.entity.UserDO;
import com.zjs.product1.mappers.EasyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/27 16:17
 */
@Mapper
public interface OrderMapper extends EasyMapper<OrderDO> {
}
