package com.lzwing.service;

import com.lzwing.mq.rocketmq.RocketMQService;
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
 * Date: 2018/5/9
 * Time: 14:25
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RocketMQServiceTest {

    @Autowired
    RocketMQService rocketMQService;

    @Test
    public void send() {
        rocketMQService.send();
    }
}