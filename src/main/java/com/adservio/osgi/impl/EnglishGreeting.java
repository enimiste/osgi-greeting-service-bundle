package com.adservio.osgi.impl;

import com.adservio.osgi.definition.Greeting;

public class EnglishGreeting implements Greeting {
    @Override
    public String sayHello(String name) {
        return "Hi %s, how are you".formatted(name);
    }
}
