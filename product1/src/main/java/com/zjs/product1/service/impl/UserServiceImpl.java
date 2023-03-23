package com.zjs.product1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjs.product1.dao.UserMapper;
import com.zjs.product1.entity.UserDO;
import com.zjs.product1.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/22 10:59
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
}
