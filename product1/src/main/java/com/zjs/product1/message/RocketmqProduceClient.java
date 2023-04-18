package com.zjs.product1.message;

import com.netflix.client.ClientException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;


import java.time.Duration;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/4/18 15:27
 */
@Slf4j
@Component
public class RocketmqProduceClient implements MessageProduceClient {
    @SneakyThrows
    @Override
    public boolean sendMessage(String topic, byte[] msgbody,String msgKey,String tag) {
        DefaultMQProducer producer = new DefaultMQProducer("DefaultCluster"); // ACL权限);
        // 设置NameServer的地址
        producer.setNamesrvAddr("101.42.251.121:10911");
        // 启动Producer实例
        producer.start();



        // 普通消息发送。
        Message message = new Message(topic,tag,msgKey,msgbody);
        SendResult send = producer.send(message);
        log.info(send.toString());
        //producer.close();
        return true;
    }
}
