package com.lzwing.starter;

import com.lzwing.base.BaseWebTest;
import com.lzwing.starter.service.WrapperService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/7/21
 * Time: 22:12
 */
@Slf4j
public class Tester extends BaseWebTest{

    @Autowired
    WrapperService wrapperService;

    @Test
    public void testStarter() {
        String test = wrapperService.wrap("test");

        log.info("str:{}", test);
    }
}
