package com.zjs.product1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.netflix.discovery.converters.Auto;
import com.zjs.product1.dao.UserMapper;
import com.zjs.product1.entity.UserDO;
import com.zjs.product1.utils.MyUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;
import java.util.List;

/**
 * @author 名字
 * @company 公司
 * @create 2023-03-15 21:10
 */

@Service
public interface ProductService{
    public String test(String name);
    public String methodOne(String name);
    public List<UserDO> selectUser(String name);
    public List<UserDO> selectUserById(String id);
    public String batchInsert(long num);
    public String batchInsert1(long num);
}
