package com.lzwing.guice.greeting;

import com.google.inject.servlet.RequestScoped;
import com.lzwing.guice.core.MyApplet;

import javax.inject.Inject;

@RequestScoped
public class GreetingHandler {

    private final RequestParams params;
    private final WebDestination destination;
    private final MyApplet applet;

    @Inject
    public GreetingHandler(
            RequestParams params,
            WebDestination destination,
            MyApplet applet) {
        this.params = params;
        this.destination = destination;
        this.applet = applet;
    }

    public String getByName(String name) {
        params.setGreetingName(name);
        applet.run();
        return destination.getResult();
    }
}
