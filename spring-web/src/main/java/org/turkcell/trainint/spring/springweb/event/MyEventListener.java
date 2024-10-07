package org.turkcell.trainint.spring.springweb.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(final MyEvent event) {
        System.out.println("I got event : " + event + " thread : " + Thread.currentThread().getName());
    }
}
