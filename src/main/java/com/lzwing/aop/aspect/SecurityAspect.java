package com.lzwing.aop.aspect;

import com.lzwing.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/8
 * Time: 10:29
 */
@Aspect
@Component
public class SecurityAspect {

    @Autowired
    AuthService authService;

    @Pointcut("@annotation(com.lzwing.aop.annotations.AdminOnly)")
    public void adminOnly() {

    }

    @Before("adminOnly()")
    public void check() {
        authService.checkAccess();
    }

}
