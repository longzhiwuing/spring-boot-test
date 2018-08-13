package com.lzwing.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AsyncHandler {
    @Async
    public void doSync(String name) {
        log.info("AsyncTester:{}",name);
    }
}