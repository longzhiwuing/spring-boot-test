package com.lzwing.servletcomponent;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class AttrListener implements ServletContextListener {
 
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent
          .getServletContext()
          .setAttribute("servlet-context-attr", "test");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.debug("AttrListener contextDestroyed......");
    }
}