package com.lzwing.guice.greeting;

import com.google.inject.servlet.RequestScoped;
import com.lzwing.guice.core.MyDestination;

import javax.inject.Inject;

@RequestScoped
public class WebDestination implements MyDestination {
    private final StringBuilder sb;

    @Inject
    public WebDestination() {
        System.out.println("WebDestination constructed.");
        this.sb = new StringBuilder();
    }

    @Override
    public void write(String string) {
        sb.append(string);
    }

    public String getResult() {
        return sb.toString();
    }
}
