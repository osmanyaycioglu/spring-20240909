package org.turkcell.trainint.spring.springweb.aop;

import org.springframework.stereotype.Component;

@Component
public class MyObject {

    public String hello(String str){
        return "Hello " + str;
    }

    public String goodbye(String str){
        return "Goodbye " + str;
    }

}
