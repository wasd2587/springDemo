package com.zjs.product1.message;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/4/18 15:22
 */
public interface MessageProduceClient {
    boolean sendMessage(String topic, byte[] msgbody,String msgKey,String tag);
}
