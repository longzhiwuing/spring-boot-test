package com.lzwing.service;

import com.lzwing.mq.kafka.KafkaMessageConsumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/10
 * Time: 10:24
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KafkaMessageSendServiceTest {

    @Autowired
    private KafkaMessageSendService kafkaMessageSendService;

    @Autowired
    KafkaMessageConsumer kafkaMessageConsumer;

    @Test
    public void send() {
        String message = "hello hahaha kafka!!!---!!!";
        try {
            kafkaMessageSendService.send(message);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}