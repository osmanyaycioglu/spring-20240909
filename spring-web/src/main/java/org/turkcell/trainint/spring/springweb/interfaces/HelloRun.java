package org.turkcell.trainint.spring.springweb.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.turkcell.trainint.spring.springweb.configuration.MyAppProperties;

import java.util.Arrays;

@Component
public class HelloRun implements ApplicationRunner {
    private final IHello hello;
    private final IHello[]        hellos;
    private final MyAppProperties myAppProperties;

    public HelloRun(@Qualifier("helloMain") IHello hello,
                    IHello[] hellos,
                    MyAppProperties myAppProperties,
                    ApplicationContext contextParam) {
        this.hello           = hello;
        this.hellos          = hellos;
        this.myAppProperties = myAppProperties;
        Arrays.stream(hellos).forEach(System.out::println);
        String[] beanNamesForTypeLoc = contextParam.getBeanNamesForType(IHello.class);
        for (String sLoc : beanNamesForTypeLoc) {
            IHello beanLoc = (IHello) contextParam.getBean(sLoc);
            System.out.println("My loop : " + beanLoc.getClass().getName());
        }
    }


    @Override
    public void run(final ApplicationArguments args) throws Exception {
        System.out.println(hello.sayHello("osman"));
        System.out.println("Properties : " + myAppProperties);
    }

}
