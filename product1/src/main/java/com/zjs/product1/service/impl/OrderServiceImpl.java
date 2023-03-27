package com.zjs.product1.service.impl;

import com.zjs.product1.Enum.OrdStasEnum;
import com.zjs.product1.dao.OrderMapper;
import com.zjs.product1.entity.OrderDO;
import com.zjs.product1.service.OrderSeervice;
import com.zjs.product1.utils.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/27 16:19
 */
@Service
public class OrderServiceImpl implements OrderSeervice {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public String batchMockInsert(Integer num) {
        ArrayList<OrderDO> list = new ArrayList<>();
        if (num > 50000){
            while (num > 0){
                for (int i = 0; i < 50000; i++) {
                    list.add(this.build());
                }
                int i = orderMapper.insertBatchSomeColumn(list);
                num = num - 50000;
            }
        }else {
            for (int i = 0; i < num; i++) {
                list.add(this.build());
            }
            int i = orderMapper.insertBatchSomeColumn(list);
        }

        return "succ";
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
}
