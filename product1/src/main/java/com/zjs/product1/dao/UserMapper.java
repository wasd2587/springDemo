package com.zjs.product1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjs.product1.entity.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/22 10:05
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
/*    @Insert("INSERT INTO user_b VALUES (NULL, #{param.userName}, #{param.age}, #{param.address}, #{param.descp})")
    int insert(@Param("param") UserDO param);*/

}
