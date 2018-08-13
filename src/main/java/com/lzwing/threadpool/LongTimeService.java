package com.lzwing.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/13
 * Time: 16:46
 */
@Service
@Slf4j
public class LongTimeService {

    @Async("myExecutor")
    public void doLongTimeService() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        log.info("doLongTimeService 执行完毕......");
    }
}
