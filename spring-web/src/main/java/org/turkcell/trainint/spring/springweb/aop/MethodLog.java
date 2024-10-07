package org.turkcell.trainint.spring.springweb.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodLog {
    ELogLevel logLevel() default ELogLevel.INFO;

    boolean methodTime() default false;

    String prefix();
}
