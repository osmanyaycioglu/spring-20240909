package org.turkcell.trainint.spring.springweb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCoreConfigBean {

    @Bean
    @Qualifier("my-bean-1")
    public MyBean myBean2(){
        return new MyBean();
    }

    @Bean
    public MyBean myBean3(){
        return new MyBean();
    }

}
