package org.turkcell.trainint.spring.springweb.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyAllEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(final ApplicationEvent event) {
        System.out.println("all event : "
                           + event.getClass()
                                  .getName()
                           + " event : "
                           + event
                           + " thread : "
                           + Thread.currentThread()
                                   .getName());
    }
}
