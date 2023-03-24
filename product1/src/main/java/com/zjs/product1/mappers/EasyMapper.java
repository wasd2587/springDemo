package com.zjs.product1.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/24 9:58
 */
public interface EasyMapper<T> extends BaseMapper<T> {
    int insertBatchSomeColumn(Collection<T> entityList);
}
