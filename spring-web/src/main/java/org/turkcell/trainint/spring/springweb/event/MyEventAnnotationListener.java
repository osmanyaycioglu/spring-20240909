package org.turkcell.trainint.spring.springweb.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventAnnotationListener {

    @EventListener
    public void listen(MyEvent myEventParam) {
        System.out.println("I got annotation : " + myEventParam + " thread : " + Thread.currentThread()
                                                                                       .getName());
    }

}
