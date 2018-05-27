package com.lzwing.guice.greeting;


import com.google.inject.AbstractModule;
import com.lzwing.guice.core.MyApplet;
import com.lzwing.guice.core.MyDestination;
import com.lzwing.guice.core.Output;
import com.lzwing.guice.core.StringWritingApplet;

public class HelloWorldWebModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(MyApplet.class).to(StringWritingApplet.class);
    bind(MyDestination.class).to(WebDestination.class);

    bind(String.class).annotatedWith(Output.class)
      .toProvider(GreetingMessageProvider.class);
  }
}
