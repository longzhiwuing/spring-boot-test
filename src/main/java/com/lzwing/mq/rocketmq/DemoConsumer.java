package com.lzwing.mq.rocketmq;

import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

//@MQConsumer(topic = "lzwing-topic", consumerGroup = "lzwing-consumer-group")
@Slf4j
public class DemoConsumer extends AbstractMQPushConsumer {

    @Override
    public boolean process(Object message, Map extMap) {
        // extMap 中包含messageExt中的属性和message.properties中的属性
        //System.out.println(message);

        log.error("rocketmq info:{}",message);

        return true;
    }
}