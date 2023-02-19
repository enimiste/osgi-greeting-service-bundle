package com.adservio.osgi.impl;

import com.adservio.osgi.definition.Greeting;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class GreetingBundle implements BundleActivator {
    private Set<ServiceRegistration<Greeting>> registrations = new HashSet<>();

    public void start(BundleContext bundleContext) throws Exception {

        this.registrations.add(bundleContext.registerService(Greeting.class,
                new ArabicGreeting(),
                new Hashtable<>()));
        this.registrations.add(bundleContext.registerService(Greeting.class,
                new EnglishGreeting(),
                new Hashtable<>()));
        System.out.println("%s started with %d registrations".formatted(this.getClass().getName(),
                this.registrations.size()));
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("%s stopped".formatted(this.getClass().getName()));
        this.registrations.forEach(ServiceRegistration::unregister);
    }
}
