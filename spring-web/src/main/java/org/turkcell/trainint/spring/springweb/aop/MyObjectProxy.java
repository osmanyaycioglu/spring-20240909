package org.turkcell.trainint.spring.springweb.aop;

public class MyObjectProxy extends MyObject {
    private MyObject myObject;

    public MyObjectProxy() {
        myObject = new MyObject();
    }

    public String hello(String str){
        System.out.println("hello calling");
        String helloLoc = myObject.hello(str);
        System.out.println("hello called");
        return helloLoc + " proxy";
    }

    public String goodbye(String str){
        return "Goodbye " + str;
    }

}
