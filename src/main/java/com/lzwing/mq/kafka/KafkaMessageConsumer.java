package com.lzwing.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

//@Component
@Slf4j
public class KafkaMessageConsumer {

    @KafkaListener(topics={"${kafka.app.topic.foo}"})
    public void receive(@Payload String message, @Headers MessageHeaders headers){
        log.error("KafkaMessageConsumer 接收到消息："+message);
        headers.keySet().forEach(key->log.info("{}: {}",key,headers.get(key)));
    }
}