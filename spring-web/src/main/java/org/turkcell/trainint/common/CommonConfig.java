package org.turkcell.trainint.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean
    public CommonBean commonBean(){
        return new CommonBean();
    }

}
