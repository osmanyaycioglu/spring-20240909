package org.turkcell.trainint.spring.springweb.another;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.turkcell.trainint.common.CommonBean;
import org.turkcell.trainint.spring.springweb.MyBean;

@RequiredArgsConstructor
// @AllArgsConstructor
public class FullBean {
    private final CommonBean commonBean;
    private final AnotherBean anotherBean;
    private String string;

}
