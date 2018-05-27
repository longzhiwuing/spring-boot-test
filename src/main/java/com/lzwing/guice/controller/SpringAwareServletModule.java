package com.lzwing.guice.controller;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.lzwing.guice.persistence.SampleDao;
import org.springframework.context.ApplicationContext;

public class SpringAwareServletModule extends AbstractModule {
  private final ApplicationContext context;

  public SpringAwareServletModule(ApplicationContext context) {
    this.context = context;
  }

  @Override
  public void configure() {
    install(new ServletModule());
    bind(ApplicationContext.class).toInstance(context);
  }

  @Provides
  SampleDao getSampleDao(ApplicationContext context) {
    return context.getBean(SampleDao.class);
  }
}
