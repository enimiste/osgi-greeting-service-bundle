package com.adservio.osgi.impl;

import com.adservio.osgi.definition.Greeting;

public class ArabicGreeting implements Greeting {
    @Override
    public String sayHello(String name) {
        return "Salam %s, Kif 7alek".formatted(name);
    }
}
