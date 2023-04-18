package com.zjs.product1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjs.product1.Enum.OrdStasEnum;
import com.zjs.product1.dao.OrderMapper;
import com.zjs.product1.entity.OrderDO;
import com.zjs.product1.service.OrderSeervice;
import com.zjs.product1.utils.MyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/27 16:19
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderDO> implements OrderSeervice {
    @Resource
    private OrderMapper orderMapper;
    private static final int INSERT_NUM = 1000;

    @Override
    public String batchMockInsert(Integer num) {
        int index = 1;
        ArrayList<OrderDO> list = new ArrayList<>();
        if (num > INSERT_NUM){
            while (num > 0){
                for (int i = 0; i < INSERT_NUM; i++) {
                    list.add(this.build());
                }
                //int i = orderMapper.insertBatchSomeColumn(list);
                this.saveBatch(list,INSERT_NUM);
                list.clear();
                num = num - INSERT_NUM;
                log.info("循环插入第" + index++ + "次");
            }
        }else {
            for (int i = 0; i < num; i++) {
                list.add(this.build());
            }
            int i = orderMapper.insertBatchSomeColumn(list);
        }

        return "succ";
    }

    @Override
    public OrderDO getOrderByName(String name,int pageNum,int pageSize) {
        /*orderMapper.selectList()*/
        return null;
    }

    @Override
    public String unionUserAndOrder() {
        return null;
    }

    private OrderDO build(){
        String ord = MyUtil.getRandomOrd();
        String name = ord.split("-")[0];
        BigDecimal pric = new BigDecimal(ord.split("-")[1]);
        BigDecimal ordNum = new BigDecimal((int) (Math.random() * 100));
        Date date = MyUtil.randomDate();
        OrderDO build = OrderDO.builder()
                .skuName(name)
                .pric(pric)
                .sukNum(ordNum)
                .feeAmount(pric.multiply(ordNum))
                .ordStas(OrdStasEnum.getRandum())
                .seltTime(date)
                .updtTime(date)
                .validFlag(true).build();
        return build;
    }

    /**
     *
     * @param entityList
     * @param batchSize
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean saveBatch(Collection<OrderDO> entityList, int batchSize) {
        try {
            int size = entityList.size();
            int idxLimit = Math.min(batchSize, size);
            int i = 1;
            //保存单批提交的数据集合
            List<OrderDO> oneBatchList = new ArrayList<>();
            for(Iterator<OrderDO> var7 = entityList.iterator(); var7.hasNext(); ++i) {
                OrderDO element = var7.next();
                oneBatchList.add(element);
                if (i == idxLimit) {
                    orderMapper.insertBatchSomeColumn(oneBatchList);
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
