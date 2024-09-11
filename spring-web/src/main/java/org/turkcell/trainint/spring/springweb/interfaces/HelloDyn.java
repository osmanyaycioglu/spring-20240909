package org.turkcell.trainint.spring.springweb.interfaces;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HelloDyn implements IHello{
    private final String helloPrefix;
    private final String goodbyePrefix;


    public String sayHello(String name) {
        return helloPrefix + " : " + name;
    }

    public String sayGoodbye(String name) {
        return goodbyePrefix + " : " + name;
    }

}
