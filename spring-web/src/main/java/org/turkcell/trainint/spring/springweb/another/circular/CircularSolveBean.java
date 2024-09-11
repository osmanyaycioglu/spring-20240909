package org.turkcell.trainint.spring.springweb.another.circular;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircularSolveBean {

    @Bean
    public FirstBean firstBean() {
        SecondBean secondBeanLoc = secondBean();
        ThirdBean thirdBeanLoc = thirdBean(secondBeanLoc);
        FirstBean  firstBeanLoc  = new FirstBean(thirdBeanLoc);
        secondBeanLoc.setFirstBean(firstBeanLoc);
        return firstBeanLoc;
    }

    @Bean
    public SecondBean secondBean() {
        return new SecondBean();
    }

    @Bean
    public ThirdBean thirdBean(SecondBean secondBeanParam) {
        return new ThirdBean(secondBeanParam);
    }

}
