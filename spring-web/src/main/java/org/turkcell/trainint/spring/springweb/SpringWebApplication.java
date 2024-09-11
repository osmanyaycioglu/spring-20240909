package org.turkcell.trainint.spring.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"org.turkcell.trainint.spring.springweb",
//                                           "org.turkcell.trainint.common"
//})
@SpringBootApplication
public class SpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class,
                              args);
    }

}
