package org.turkcell.trainint.spring.springweb.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,
         ElementType.TYPE,
         ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(CheckPropertyImpl.class)
public @interface CheckProperty {
    String key();

    String val();
}
