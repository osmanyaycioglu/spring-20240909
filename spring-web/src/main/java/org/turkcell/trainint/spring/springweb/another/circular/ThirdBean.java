package org.turkcell.trainint.spring.springweb.another.circular;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
public class ThirdBean {
    private final SecondBean firstBean;


}
