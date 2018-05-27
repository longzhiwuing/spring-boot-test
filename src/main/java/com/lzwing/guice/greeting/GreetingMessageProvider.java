package com.lzwing.guice.greeting;

import com.google.inject.Provider;
import com.lzwing.guice.persistence.SampleDao;

import javax.inject.Inject;

public class GreetingMessageProvider
        implements Provider<String> {
    private final RequestParams params;
    private final SampleDao dao;

    @Inject
    public GreetingMessageProvider(
            RequestParams params, SampleDao dao) {
        this.params = params;
        this.dao = dao;
    }

    @Override
    public String get() {
        String name = params.getGreetingName();
        dao.getPersonData(name);
        return "Hello " + name;
    }
}
