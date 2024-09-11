package org.turkcell.trainint.spring.springweb.interfaces;

import org.springframework.stereotype.Component;

@Component("helloEng")
public class Hello implements IHello{

    public String sayHello(String name) {
        return "Hello : " + name;
    }

    public String sayGoodbye(String name) {
        return "Goodbye : " + name;
    }

}
