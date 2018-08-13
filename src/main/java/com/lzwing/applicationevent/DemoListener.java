package com.lzwing.applicationevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/***
 * 
  * @ClassName(类名)      : demoListener
  * @Description(描述)    : 事件监听器
  *                     实现ApplicationListener并制定监听的事件类型
  * @date (开发日期)      ：2017年11月22日 下午3:35:37
  *
 */
@Component
@Slf4j
public class DemoListener implements ApplicationListener<DemoEvent> {

    /***
     * 对消息进行接受处理
     */
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        log.info("---demoListener接受到了demoPublisher发布的消息：---"+msg);
    }


}