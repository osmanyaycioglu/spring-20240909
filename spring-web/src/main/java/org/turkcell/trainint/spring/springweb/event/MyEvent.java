package org.turkcell.trainint.spring.springweb.event;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
public class MyEvent extends ApplicationEvent {
    @Getter
    private final String msg;

    public MyEvent(final Object source,String msg) {
        super(source);
        this.msg = msg;
    }

}
