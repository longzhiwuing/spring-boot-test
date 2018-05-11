package com.lzwing.service;

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
 * Time: 11:36
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RetryServiceTest {

    @Autowired
    RetryService retryService;

    @Test
    public void minGoodsnum() throws Exception {
        int store = retryService.minGoodsnum(-1);
        System.out.println("库存为：" + store);
    }
}