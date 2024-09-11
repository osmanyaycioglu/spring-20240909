package org.turkcell.trainint.spring.springweb.another;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.turkcell.trainint.spring.springweb.MyBean;

@Component
public class AnotherBean {

    private MyBean myBean;

    // field injection
    @Autowired
    @Qualifier("myBean2")
    private MyBean myBeantest; // 3 reflection code - 1. constructor 2. field set 3.postcontruct

    private MyBean myBeanAnotherTest;

    public AnotherBean() {
    }

    // constructor injection
    @Autowired
    public AnotherBean(@Qualifier("myBean") final MyBean myBeanParam) { // 1 reflection code
        myBean = myBeanParam;
        myBeanParam.hello();
    }

    public AnotherBean(@Qualifier("myBean") final MyBean myBeanParam,
                       String str) {
        myBean = myBeanParam;
    }

    // method injection
    @Autowired
    @Qualifier("myBean3")
    public void method(MyBean myBeanParam){
        myBeanAnotherTest = myBeanParam;
    }

    @PostConstruct
    public void init(){
        myBeantest.hello();
    }

    @PreDestroy
    public void destroy(){
        // close resources
    }

}
