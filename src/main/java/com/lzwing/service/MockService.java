package com.lzwing.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/8
 * Time: 10:30
 */

import com.lzwing.aop.annotations.AdminOnly;
import org.springframework.stereotype.Service;

@Service
public class MockService {

    @AdminOnly
    public void insert(String info) {
        System.out.println("mock insert...");
    }

    @AdminOnly
    public void delete(String info) {
        System.out.println("mock delete");
    }
}
