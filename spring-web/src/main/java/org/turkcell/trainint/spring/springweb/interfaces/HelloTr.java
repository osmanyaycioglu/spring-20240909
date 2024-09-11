package org.turkcell.trainint.spring.springweb.interfaces;

import org.springframework.stereotype.Component;

@Component
public class HelloTr implements IHello{

    public String sayHello(String name) {
        return "Merhaba : " + name;
    }

    public String sayGoodbye(String name) {
        return "Güle güle : " + name;
    }

}
