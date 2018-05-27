package com.lzwing.guice.controller;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lzwing.guice.greeting.GreetingHandler;
import com.lzwing.guice.greeting.HelloWorldWebModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
public class SampleController {

    @Bean
    Injector injector(ApplicationContext context) {
        return Guice.createInjector(
                new HelloWorldWebModule(),
                new SpringAwareServletModule(context));
    }

    @Bean
    @RequestScope
    GreetingHandler greetingHandler(
            Injector injector) {
        return injector.getInstance(GreetingHandler.class);
    }

    @Autowired
    GreetingHandler greetingHandler;

    @GetMapping("/greeting")
    String greeting(@RequestParam("name") String name) {
        return greetingHandler.getByName(name);
    }
}