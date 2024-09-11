package org.turkcell.trainint.spring.springweb.another.circular;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class FirstBean {
    private final ThirdBean firstBean;


}
