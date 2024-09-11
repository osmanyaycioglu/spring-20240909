package org.turkcell.trainint.spring.springweb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Lazy
@Component

//@Controller
//@Repository
//@Service
//@Configuration
// @Primary
@Qualifier("my-bean-1")
public class MyBean {

    public void hello(){
        System.out.println("Hello world");
    }

}
