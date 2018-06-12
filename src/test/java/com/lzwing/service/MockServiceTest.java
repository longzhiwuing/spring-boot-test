package com.lzwing.service;

import com.lzwing.aop.security.CurrentUserHolder;
import com.lzwing.base.BaseWebTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/12
 * Time: 11:09
 */
public class MockServiceTest extends BaseWebTest{

    @Autowired
    MockService mockService;

    @Test(expected = RuntimeException.class)
    public void insert() {
        CurrentUserHolder.set("tom");
        mockService.insert("test");
    }

    @Test
    public void delete() {
        CurrentUserHolder.set("admin");
        mockService.delete("test delete....");
    }

}