package com.zjs.product1.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/27 15:57
 */
@TableName(value = "order_b")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDO {
    @TableId
    private String id;
    @TableField("sku_name")
    private String skuName;
    @TableField("sku_num")
    private BigDecimal sukNum;
    @TableField("pric")
    private BigDecimal pric;
    @TableField("fee_amount")
    private BigDecimal feeAmount;
    @TableField("ord_stas")
    private int ordStas;
    @TableField("selt_time")
    private Date seltTime;
    @TableField("updt_time")
    private Date updtTime;
    @TableField("valid_flag")
    private boolean validFlag;
}
