package com.lzwing.service;

import com.lzwing.aop.security.CurrentUserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/8
 * Time: 10:43
 */
@Service
@Slf4j
public class AuthService {

    public void checkAccess() {
        log.info("AuthService.checkAccess......");
        String user = CurrentUserHolder.get();
        if (!"admin".equals(user)) {
            throw new RuntimeException("no access authroity");
        }
    }
}
