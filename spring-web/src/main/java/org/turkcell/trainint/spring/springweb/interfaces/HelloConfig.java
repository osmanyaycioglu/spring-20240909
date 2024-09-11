package org.turkcell.trainint.spring.springweb.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.turkcell.trainint.spring.springweb.conditional.CheckProperty;
import org.turkcell.trainint.spring.springweb.configuration.MyAppProperties;

@Configuration
// @Profile("dev")
@PropertySource("classpath:my.properties")
@CheckProperty(key="hello.runtime",val = "development")
@RequiredArgsConstructor
public class HelloConfig {
    private final MyAppProperties myAppProperties;


    @Bean("helloMain2")
    public IHello helloMain2(@Value("${app.language}") String language){
        switch (language) {
            case "tr":
                return new HelloTr();
            case "eng":
            default:
                return new Hello();
        }
    }

    @Bean("helloMain3")
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

    @Bean("helloMain")
    public IHello helloMainXYZ(Environment environmentParam){
        String helloPrefix = environmentParam.getProperty("app.hello.prefix");
        String goodbyePrefix = environmentParam.getProperty("app.goodbye.prefix");
        return new HelloDyn(helloPrefix, goodbyePrefix);
    }

}
