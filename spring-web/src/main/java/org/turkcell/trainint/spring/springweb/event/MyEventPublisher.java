package org.turkcell.trainint.spring.springweb.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

// @Component
@RequiredArgsConstructor
public class MyEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public void publishEvent(String msg) {
        MyEvent myEventLoc = new MyEvent(this,
                                         msg);
        eventPublisher.publishEvent(myEventLoc);
    }
}
