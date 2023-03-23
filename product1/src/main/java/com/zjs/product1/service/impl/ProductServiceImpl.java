package com.zjs.product1.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zjs.product1.dao.UserMapper;
import com.zjs.product1.entity.UserDO;
import com.zjs.product1.service.ProductService;
import com.zjs.product1.service.UserService;
import com.zjs.product1.utils.MyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/22 10:51
 */
@Slf4j
@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public String test(String name){
        String result = null;
        try {
            Thread.sleep(2000);
            result = "\"HI \" + name + \",I'm P1\"";
            log.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String methodOne(String name) {
        long start = System.currentTimeMillis();
        UserDO build = UserDO.builder()
                .userName(MyUtil.randName())
                .age(MyUtil.randAge())
                .address(MyUtil.getRandomIp())
                .descp("(备注为空)")
                .build();
        //boolean save = userService.save(build);
        int insert = userMapper.insert(build);
        boolean save = insert > 0 ? true : false;
        //userMapper.saveBatch();
        System.out.println("spend time: " + String.valueOf(System.currentTimeMillis() - start));
        return save?"success":"fail";
    }

    @Override
    public List<UserDO> selectUser(String name) {
        List<UserDO> list = userMapper.selectList(Wrappers.lambdaQuery(UserDO.class).like(UserDO::getUserName, name));
        return list;
    }

    @Override
    public String batchInsert(long num) {
        long start = System.currentTimeMillis();
        log.info("start time",start);
        ArrayList<UserDO> list = new ArrayList<>();
        for (long i = 0; i < num; i++) {
            UserDO build = UserDO.builder()
                    .userName(MyUtil.randName())
                    .age(MyUtil.randAge())
                    .address(MyUtil.getRandomIp())
                    .descp("(备注为空)")
                    .build();
            list.add(build);
        }
        boolean b = userService.saveBatch(list);
        long end = System.currentTimeMillis();
        log.info("end time",end);
        log.info("spend time: " + ((double)(end - start))/ 1000.00);
        return b?"success":"fail";
    }

    @Override
    public String batchInsert1(long num) {
        long start = System.currentTimeMillis();
        log.info("start time",start);
        ArrayList<UserDO> list = new ArrayList<>();
        for (long i = 0; i < num; i++) {
            UserDO build = UserDO.builder()
                    .userName(MyUtil.randName())
                    .age(MyUtil.randAge())
                    .address(MyUtil.getRandomIp())
                    .descp("(备注为空)")
                    .build();
            list.add(build);
        }
        boolean b = userService.saveBatch(list,100000);
        long end = System.currentTimeMillis();
        log.info("end time",end);
        log.info("spend time: " + ((double)(end - start))/ 1000.00);
        return b?"success":"fail";
    }
}
