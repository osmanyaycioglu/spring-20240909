package org.turkcell.trainint.spring.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@SpringBootApplication(scanBasePackages = {"org.turkcell.trainint.spring.springweb",
//                                           "org.turkcell.trainint.common"
//})
@SpringBootApplication
// @EnableAsync
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
// @ServletComponentScan
public class SpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class,
                              args);
    }

}
