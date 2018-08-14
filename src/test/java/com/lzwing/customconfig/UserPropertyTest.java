package com.lzwing.customconfig;

import com.lzwing.base.BaseWebTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/14
 * Time: 10:55
 */
@Slf4j
@PropertySource("classpath:custom.properties")
public class UserPropertyTest extends BaseWebTest{

    @Autowired
    UserProperty userProperty;

    @Value("${custom.nickname}")
    String nickname;

    @Value("${custom.url}")
    String url;

    @Test
    public void test() {
        log.info("test:{}",userProperty);
        log.info("nickname:{}",nickname);
        log.info("url:{}",url);
    }
}