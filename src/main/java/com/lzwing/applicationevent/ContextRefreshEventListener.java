package com.lzwing.applicationevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/13
 * Time: 16:01
 */
@Slf4j
@Component
public class ContextRefreshEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext ac = event.getApplicationContext();
        //这里的条件保证启动业务逻辑的启动是在spring框架完成初始化以后
        if (ac.getParent() == null) {
            //开始初始化业务逻辑
            log.info("===spring框架初始化完毕===");
            ac.publishEvent(new DemoEvent(this, "spring框架初始化完毕..."));
        }
    }
}
