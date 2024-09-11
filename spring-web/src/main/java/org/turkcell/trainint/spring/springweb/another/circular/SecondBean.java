package org.turkcell.trainint.spring.springweb.another.circular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

public class SecondBean {
    @Getter
    @Setter
    private FirstBean firstBean;



}
