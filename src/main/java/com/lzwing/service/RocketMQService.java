package com.lzwing.service;

import com.lzwing.mq.rocketmq.DemoConsumer;
import com.lzwing.mq.rocketmq.DemoProducer;
import com.maihaoche.starter.mq.base.MessageBuilder;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/9
 * Time: 14:21
 */
//@Service
public class RocketMQService {

    @Autowired
    private DemoProducer demoProducer;

    @Autowired
    private DemoConsumer consumer;

    public void send() {

        Map<String, String> data = new HashMap<>();
        data.put("aaaa", "1111");
        data.put("bbbb", "2222");

        Message msg = MessageBuilder.of(data).topic("lzwing-topic").build();
        // 发送
        demoProducer.syncSend(msg);
    }
}
