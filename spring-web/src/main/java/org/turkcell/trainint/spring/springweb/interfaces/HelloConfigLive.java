package org.turkcell.trainint.spring.springweb.interfaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.turkcell.trainint.spring.springweb.conditional.CheckProperty;

@Configuration
// @Profile("live")
@PropertySource("classpath:my.properties")
@CheckProperty(key="hello.runtime",val = "live")
public class HelloConfigLive {

    @Bean("helloMain")
    public IHello helloMain3(Environment environmentParam){
        String language = environmentParam.getProperty("app.language");
        switch (language) {
            case "tr":
                return new HelloTr();
            case "eng":
            default:
                return new Hello();
        }
    }

}
