package com.lzwing.aop;

import com.lzwing.aop.aspect.SecurityAspect;
import com.lzwing.base.BaseWebTest;
import com.lzwing.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/7/27
 * Time: 9:54
 */
@Slf4j
public class AopUtilsTest extends BaseWebTest {

    @Autowired
    AuthService authService;

    @Autowired
    SecurityAspect securityAspect;

    @Test
    public void test() {
        boolean isaopproxy = AopUtils.isAopProxy(securityAspect);
        log.info("isaopproxy = " + isaopproxy);
    }
}
