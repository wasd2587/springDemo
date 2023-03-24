package com.zjs.product1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjs.product1.dao.UserMapper;
import com.zjs.product1.entity.UserDO;
import com.zjs.product1.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/22 10:59
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
    @Resource
    private UserMapper userMapper;


    /**
     *
     * @param entityList
     * @param batchSize
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean saveBatch(Collection<UserDO> entityList, int batchSize) {
        try {
            int size = entityList.size();
            int idxLimit = Math.min(batchSize, size);
            int i = 1;
            //保存单批提交的数据集合
            List<UserDO> oneBatchList = new ArrayList<>();
            for(Iterator<UserDO> var7 = entityList.iterator(); var7.hasNext(); ++i) {
                UserDO element = var7.next();
                oneBatchList.add(element);
                if (i == idxLimit) {
                    userMapper.insertBatchSomeColumn(oneBatchList);
                    //每次提交后需要清空集合数据
                    oneBatchList.clear();
                    idxLimit = Math.min(idxLimit + batchSize, size);
                }
            }
        }catch (Exception e){
            log.error("saveBatch fail",e);
            return false;
        }
        return  true;
    }
}
