package org.turkcell.trainint.spring.springweb.aop;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {
    private final MyObject myObject;

    @Override
    public void run(final String... args) throws Exception {
        String helloLoc = myObject.hello("osman");
        System.out.println("++++++++++++++ AOP : " + helloLoc);
    }
}
